package cn.zyy.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cuixj
 * @Date: 2024-01-11 14:28
 * 改变负载均衡的算法
 */
@Configuration
public class RibbonRule {

    //配置注入自己的负载均衡算法
    @Bean
    public IRule myRibbonRule(){
        //随机算法
        return new RandomRule();
    }
}
