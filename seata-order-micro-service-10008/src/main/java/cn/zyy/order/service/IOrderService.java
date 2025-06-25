package cn.zyy.order.service;

import cn.zyy.order.entity.Order;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:27
 * @Description: 致敬
 */
public interface IOrderService {

    // 扣减库存
    void save(Order order);
}
