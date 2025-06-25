package cn.zyy.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:39
 * @Description: 致敬
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMicroServiceApplication10010 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMicroServiceApplication10010.class, args);
    }
}
