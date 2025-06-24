package cn.zyy.springcloud.controller;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.config.MemberFeignService;
import cn.zyy.springcloud.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@Slf4j
public class MemberConsumerFeignController {


    @Autowired
    private MemberFeignService memberFeignService;


    @GetMapping("/member/consumer/openfeign/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id){

        Result result = memberFeignService.queryMember(id);
        System.out.println("look and think:" + result);
        return result;
    }


    @PostMapping("/member/consumer/openfeign/save")
    public Result<Member> saveMember(@RequestBody Member member){

        Result result = memberFeignService.saveMember(member);
        log.info("服务提供方返回的结果{}",result);
        return result;
    }
}
