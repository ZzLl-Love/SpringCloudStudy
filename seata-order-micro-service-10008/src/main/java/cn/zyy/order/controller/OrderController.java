package cn.zyy.order.controller;

import cn.zyy.order.entity.Order;
import cn.zyy.springcloud.basic.Result;
import cn.zyy.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:31
 * @Description: 致敬
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/save")
    public Result save(Order order) {
        orderService.save(order);
        return Result.success("订单创建成功", null);
    }
}
