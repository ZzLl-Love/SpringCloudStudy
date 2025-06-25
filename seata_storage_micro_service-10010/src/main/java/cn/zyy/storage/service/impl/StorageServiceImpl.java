package cn.zyy.storage.service.impl;

import cn.zyy.storage.dao.StorageDao;
import cn.zyy.storage.service.IStorageService;
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
public class StorageServiceImpl implements IStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 根据产品ID 扣减库存
     * @param productId
     * @param nums
     */
    @Override
    public void reduce(Long productId, Integer nums) {
        LOGGER.info("==========seata_storage_micro_service-10010 扣减库存start==========");
        storageDao.reduce(productId, nums);
        LOGGER.info("==========seata_storage_micro_service-10010 扣减库存end==========");
    }
}
