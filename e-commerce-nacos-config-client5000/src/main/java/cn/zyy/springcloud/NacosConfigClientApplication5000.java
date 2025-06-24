package cn.zyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Zz
 * @Date: 2024/02/13/13:15
 * @Description: 致敬
 *
 * 为什么需要配置中心？
 *   多个微服务需要公用的配置文件？
 *   微服务不需要重启就可以获取到最新的配置中心的信息
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientApplication5000 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication5000.class, args);
    }
}
