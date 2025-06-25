package cn.zyy.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:23
 * @Description: 致敬
 */
@Mapper
public interface AccountDao {

    //扣减账户金钱信息
    void reduce(@Param("userId") Long userId, @Param("money") Integer money);
}
