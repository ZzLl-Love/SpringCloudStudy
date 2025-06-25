package cn.zyy.order.dao;

import cn.zyy.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:23
 * @Description: 致敬
 */
@Mapper
public interface OrderDao {

    //新建订单
    void save(Order order);
    //修改订单状态
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
