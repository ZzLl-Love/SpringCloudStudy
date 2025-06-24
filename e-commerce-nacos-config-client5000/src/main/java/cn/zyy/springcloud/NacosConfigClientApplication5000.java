package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Zz
 * @Date: 2024/02/13/13:15
 * @Description: 致敬
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientApplication5000 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication5000.class, args);
    }
}
