package cn.zyy.springcloud.config;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * OpenFeign 是一个声明式的WebService 客户端
 * 使用方法：
 *  1. 点一定义服务接口然后在上面添加@FeignClient注解
 *
 *  注意点：
 *
 */
@Component
//MEMBER-SERVICE-PROVIDER 是Eureka Server中保存的服务提供者注册的名字  他是服务提供者对外提供的访问名称
@FeignClient(value="MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {

    /**
     * 消费方 调用方式为get
     * 远程调用的url: http://MEMBER-SERVICE-PROVIDER/member/{id};
     * openFeign 的均衡算法会决定是调用port  9998 还是 9999 的服务
     *
     * @param id
     * @return
     */

    @GetMapping("/member/{id}")
    public Result<Member> queryMember(@PathVariable("id") Long id);

    /**
     * 消费方 调用服务提供者进行保存
     * @param member
     * @return
     * 注意点：Feign 本质是“发 HTTP 请求”，写的路径就是它访问的路径，
     *  故： /member/save 这个路径 一定要和实际的服务提供作者的路径保持一致
     */
    @PostMapping("/member/save")
    public Result saveMember(@RequestBody Member member);


}
