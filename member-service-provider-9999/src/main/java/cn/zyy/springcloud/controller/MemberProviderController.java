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

    @Autowired
    MemberService memberService;

    @GetMapping("/{id}")
    public Result queryMember(@PathVariable("id") Long id){

        log.info("==P会员服务模块拿到需要查询用户id:{}  P==",id);

        Member member = memberService.queryMemberById(id);
        if(member!=null){
            return Result.success("查询成功", member);
        }else{
            return Result.error("400", "没有查询到用户信息");
        }
    }

    @PostMapping("/save")
    public Result saveMember(@RequestBody Member member){

        if(member == null){
            return Result.error("4002", "请求参数为空");
        }

        log.info("==P会员服务模块添加的会员信息为:{}  P==", member);

        int i = memberService.insertMember(member);
        if(i>0){
             return Result.success("添加会员信息成功","添加条数为"+i);
        }else {
             return Result.error("4002", "添加失败");
        }
    }

}
