package cn.zyy.springcloud.config;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.springcloud.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="MEMBER-SERVICE-PROVIDER")  //MEMBER-SERVICE-PROVIDER 是Eureka Server 对外提供的访问名称
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

}
