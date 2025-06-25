package cn.zyy.storage.controller;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.storage.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:31
 * @Description: 致敬
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private IStorageService storageService;

    //扣减库存
    @PostMapping("/reduce")
    public Result reduce(Long productId, Integer nums) {
        storageService.reduce(productId, nums);
        return Result.success("扣减库存成功 ok", null);
    }
}
