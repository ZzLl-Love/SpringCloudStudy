package cn.zyy.springcloud.controller;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.config.MemberFeignService;
import cn.zyy.springcloud.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resources;

@RestController
public class MemberConsumerFeignController {


    @Autowired
    private MemberFeignService memberFeignService;


    @GetMapping("/member/consumer/openfeign/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id){

        Result result = memberFeignService.queryMember(id);
        System.out.println("look and think:" + result);
        return result;
    }

}
