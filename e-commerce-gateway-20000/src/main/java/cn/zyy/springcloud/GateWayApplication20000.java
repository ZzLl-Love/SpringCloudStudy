package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
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
