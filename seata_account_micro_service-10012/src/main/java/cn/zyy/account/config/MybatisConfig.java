package cn.zyy.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:34
 * @Description: 致敬
 */
@Configuration
@MapperScan({"cn.zyy.account.dao"})
public class MybatisConfig {
}
