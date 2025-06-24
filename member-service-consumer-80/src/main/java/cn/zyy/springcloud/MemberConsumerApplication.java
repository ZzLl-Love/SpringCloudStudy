package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//注册启动发现服务： 可以从Eureka Server 的服务注册信息中获取到实际的注册信息
@EnableEurekaClient
@SpringBootApplication
public class MemberConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerApplication.class);
    }
}
