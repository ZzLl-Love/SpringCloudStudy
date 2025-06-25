package cn.zyy.order.openfeign;

import cn.zyy.springcloud.basic.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Zz
 * @Date: 2025/06/25/6:51
 * @Description: 致敬
 * 库存接口类
 */
@FeignClient(value = "seata-storage-micor-service")
public interface StorageService {

    @PostMapping(value = "/storage/reduce")
    Result reduce(@RequestParam("productId") Long productId, @RequestParam("nums") Integer nums);

}
