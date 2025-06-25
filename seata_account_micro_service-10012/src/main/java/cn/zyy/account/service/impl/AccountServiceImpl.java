package cn.zyy.account.service.impl;

import cn.zyy.account.dao.AccountDao;
import cn.zyy.account.service.IAccountService;
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
public class AccountServiceImpl implements IAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public void reduce(Long userId, Integer money) {
        LOGGER.info("========seata_account_micro_service-10012 扣减账户余额start ======");
        accountDao.reduce(userId,money);
        LOGGER.info("========seata_account_micro_service-10012 扣减账户余额end======");
    }
}
