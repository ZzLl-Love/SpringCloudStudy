package cn.zyy.springcloud.dao;

import cn.zyy.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Zz
 * @Date: 2023/12/28/21:57
 * @Description: 致敬
 */
@Mapper
public interface MemberDao {

    //query
    public Member queryMemberById(long id);

    //insert
    public  int saveMember(Member member);
}
