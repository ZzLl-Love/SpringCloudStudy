package cn.zyy.order.openfeign;

import cn.zyy.springcloud.basic.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Zz
 * @Date: 2025/06/25/6:49
 * @Description: 致敬
 * 账户接口类
 */
@FeignClient(value="seata-account-micor-service")
public interface AccountService {


    /**
     * 扣钱账户金钱
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/reduce")
    Result reduce(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
