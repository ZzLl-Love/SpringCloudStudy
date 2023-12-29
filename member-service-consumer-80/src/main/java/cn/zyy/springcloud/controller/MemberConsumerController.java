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
@RequestMapping("/member/consumer")
@Slf4j
public class MemberConsumerController {

    @Resource
    private RestTemplate restTemplate;

    // 提供会员服务模块的基础url
    private static final  String MEMBER_SERVICE_PROVIDER_URL = "http://localhost:9999/member/";


    //查询会员
    @GetMapping("{id}")
    public Result<Member> getMemberById(@PathVariable("id") String id){

        log.info("==C会员消费模块拿到需要查询的id:{}  C==",id);
        return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER_URL+id, Result.class);
    }

    //添加会员
    @PostMapping("/save")
    public Result<Member> saveMember(@RequestBody Member member){

        log.info("==C会员消费模块get保存用户信息consumer  C==："+ member);
       return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL+"save",member,Result.class);
    }
}
