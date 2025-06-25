package cn.zyy.account.service;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:27
 * @Description: 致敬
 */
public interface IAccountService {

    // 扣减库存
    void reduce( Long userId,Integer money);
}
