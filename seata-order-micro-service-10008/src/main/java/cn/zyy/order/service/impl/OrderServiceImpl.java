package cn.zyy.order.service.impl;

import cn.zyy.order.dao.OrderDao;
import cn.zyy.order.entity.Order;
import cn.zyy.order.openfeign.AccountService;
import cn.zyy.order.openfeign.StorageService;
import cn.zyy.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:28
 * @Description: 致敬
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     *   1.  @GlobalTransactional: 分布式全局事务控制
     * * 2. name = "hspedu-save-order" 名称自己写，保证唯一即可
     * * 3. rollbackFor = Exception.class 指定发生什么异常就回滚，
     * @param order
     */
    @Override
    @GlobalTransactional(name="hspedu-save-order", rollbackFor = Exception.class)
    public void save(Order order) {
        log.info("=========开始新建订单 start ==========");//新建订单
        orderDao.save(order);
        System.out.println("order=" + order);
        log.info("=========减库存 start ==========");
        storageService.reduce(order.getProductId(), order.getNums());
        log.info("=========减库存 end ==========");
        log.info("=========减账户金额 start ==========");
        accountService.reduce(order.getUserId(), order.getMoney());
        log.info("=========减账户金额 end ==========");
        log.info("=========修改订单状态 start ==========");
        orderDao.update(order.getUserId(), 0);
        log.info("=========修改订单状态 end ==========");
        log.info("=========下订单 end==========");
    }
}
