package cn.zyy.springcloud.controller;


import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 会员消费服务模块[member-service-consumer-80]
 *            ---通过RestTemplate 请求 ---> 提供会员服务模块[member-service-provider-10000]
 */
@RestController
@RequestMapping("/member/nacos/consumer/")
@Slf4j
public class MemberConsumerController {

    @Resource
    private RestTemplate restTemplate;

    // 提供会员服务模块的基础url
    //private static final  String MEMBER_SERVICE_PROVIDER_URL = "http://localhost:9999/member/";

    //会员服务模块变化  根据服务名去查找对应的服务的 ip + port
    //MEMBER-SERVICE-PROVIDER 是Eureka 对外暴露的名称
    public static  final  String MEMBER_SERVICE_PROVIDER_URL = "http://member-service-nacos-provider";


    //查询会员
    @GetMapping("{id}")
    public Result<Member> getMemberById(@PathVariable("id") String id){

        log.info("==C会员消费模块拿到需要查询的id:{}  C==",id);
        //凭借服务方调用的地址
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
}
