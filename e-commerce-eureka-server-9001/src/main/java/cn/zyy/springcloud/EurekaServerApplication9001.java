package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//EnableEurekaServer 表示该程序，作为Eureka的服务端
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication9001.class,args);
    }
}
