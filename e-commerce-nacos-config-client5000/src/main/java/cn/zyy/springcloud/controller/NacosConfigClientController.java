package cn.zyy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zz
 * @Date: 2024/02/13/13:17
 * @Description: 致敬
 */
@RestController
@RefreshScope //该注解 是springCloud 的原生注解，实现配置信息自动刷新
public class NacosConfigClientController {

    @Value("${config.ip}")
    private  String configIp;

    @Value("${config.name}")
    private String configName;


    @GetMapping("/nacos/config/ip")
    public String getConfigIp() {
        System.out.println("data come in server");
        return configIp;
    }

    @GetMapping("/nacos/config/name")
    public String getConfigName() {
        return configName;
    }

    @GetMapping("test")
    public String test(){
        return "test success";
    }
}
