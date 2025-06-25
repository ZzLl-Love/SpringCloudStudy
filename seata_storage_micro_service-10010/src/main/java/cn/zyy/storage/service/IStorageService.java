package cn.zyy.storage.service;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:27
 * @Description: 致敬
 */
public interface IStorageService {

    // 扣减库存
    void reduce(Long productId, Integer nums);
}
