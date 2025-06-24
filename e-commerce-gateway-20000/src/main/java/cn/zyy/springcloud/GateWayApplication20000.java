package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * Gateway 的核心功能
 *
 *  目标: 将这几种核心功能能理解他们是什么意思
 *  1.鉴权
 *  2.流量控制
 *  3.熔断
 *  4.日志监控
 *  5.反向代理
 *
 *
 *
 * @Author: cuixj
 * @Date: 2024-01-11 9:50
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication20000 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication20000.class,args);
    }
}
