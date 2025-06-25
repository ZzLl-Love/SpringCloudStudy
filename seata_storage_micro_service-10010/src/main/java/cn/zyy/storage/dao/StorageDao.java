package cn.zyy.storage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:23
 * @Description: 致敬
 */
@Mapper
public interface StorageDao {

    //扣减库存信息
    void reduce(@Param("productId") Long productId, @Param("nums") Integer nums);
}
