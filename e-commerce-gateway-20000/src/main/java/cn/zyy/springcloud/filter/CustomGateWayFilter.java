package cn.zyy.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @Author: Zz
 * @Date: 2025/06/25/2:34
 * @Description: 致敬
 */
@Component
@Slf4j
public class CustomGateWayFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("==========验证是否经过全局过滤器CustomGateWayFilter===========");
        //先获取到对应的参数
        String user = exchange.getRequest().getQueryParams().getFirst("user");
        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
        if(!("zyy".equals(user) &&"123456".equals(pwd))){
            log.warn("非法用户登录，用户名={}，密码={}", user, pwd);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


}
