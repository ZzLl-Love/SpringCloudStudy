package cn.zyy.springcloud.controller;


import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员消费服务模块[member-service-consumer-80]
 *            ---通过RestTemplate 请求 ---> 提供会员服务模块[member-service-provider-10000]
 */
@RestController
@RequestMapping("/member/consumer")
@Slf4j
public class MemberConsumerController {

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private DiscoveryClient discoveryClient;

    // 提供会员服务模块的基础url
    //private static final  String MEMBER_SERVICE_PROVIDER_URL = "http://localhost:9999/member/";

    //会员服务模块变化  根据服务名去查找对应的服务的 ip + port
    //MEMBER-SERVICE-PROVIDER [消费方的名字] 是Eureka 对外暴露的名称
    public static  final  String MEMBER_SERVICE_PROVIDER_URL = "http://MEMBER-SERVICE-PROVIDER";


    //查询会员
    @GetMapping("{id}")
    public Result<Member> getMemberById(@PathVariable("id") String id){

        log.info("==C会员消费模块拿到需要查询的id:{}  C==",id);
        //凭借服务方调用的地址 remoteUrl = http://MEMBER-SERVICE-PROVIDER/member/1
        String remoteUrl = MEMBER_SERVICE_PROVIDER_URL+"/member/"+id;
        log.info("请求地址是{}", remoteUrl );
        return restTemplate.getForObject(remoteUrl, Result.class);
    }

    //添加会员 todo 修改会员保存服务 通过eureka 调用服务集群
    @PostMapping("/save")
    public Result<Member> saveMember(@RequestBody Member member){

        log.info("==C会员消费模块get保存用户信息consumer  C==："+ member);
       return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL+"save",member,Result.class);
    }

    /**
     * 在服务消费方 查询 Eureka Server 注册的服务的实际端口，以及信息
     * @return
     */
    @GetMapping("/discovery")
    public  Result<List<ServiceInstance>> discovery(){
        //返回的信息
        List<ServiceInstance> instances = new ArrayList<>();
        // 获取Eureka Server中所有的服务名称
        List<String> servicesNames = discoveryClient.getServices();
        for (String serviceName : servicesNames) {
            log.info("===========服务名=========== {} ", serviceName);

            // 一个服务名后面可能是一个集群，包含多个服务
             instances = discoveryClient.getInstances(serviceName);
            instances.forEach(item  ->{
                log.info("===========服务名==========={},端口={}, url={}", item.getServiceId(),item.getPort(),item.getUri());
            });
        }
        return  Result.success("查询",instances);
    }

}
