package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Zz
 * @Date: 2023/12/28/21:33
 * @Description: 致敬
 */
@SpringBootApplication
@EnableDiscoveryClient
public class  MemberNacosProviderApplication10004{
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosProviderApplication10004.class, args);
    }
}
