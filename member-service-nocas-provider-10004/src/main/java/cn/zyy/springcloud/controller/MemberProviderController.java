package cn.zyy.springcloud.controller;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.entity.Member;
import cn.zyy.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberProviderController {

    private  static String  MODULE_NAME = "member-service-nacos-provider-10004";


    @Autowired
    MemberService memberService;

    @GetMapping("/{id}")
    public Result queryMember(@PathVariable("id") Long id){

        log.info("Nacos 服务注册中心");

        Member member = memberService.queryMemberById(id);
        if(member!=null){
            return Result.success(MODULE_NAME+"查询成功", member);
        }else{
            return Result.error( "400",MODULE_NAME+"没有查询到用户信息");
        }
    }

    @PostMapping("/save")
    public Result saveMember(@RequestBody Member member){

        if(member == null){
            return Result.error("4002", MODULE_NAME+"请求参数为空");
        }

        int i = memberService.insertMember(member);

        if(i>0){
             return Result.success(MODULE_NAME+"添加会员信息成功","添加条数为"+i);
        }else {
             return Result.error("4003", MODULE_NAME+"添加失败");
        }
    }

}
