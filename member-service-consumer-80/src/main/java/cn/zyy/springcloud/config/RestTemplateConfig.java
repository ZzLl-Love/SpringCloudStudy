package cn.zyy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * 向容器中注入RestTemplate 用于消费会员服务模块 发送请求到  提供会员服务模块中
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    @LoadBalanced  //使用该注解赋予RestTemplate 负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
