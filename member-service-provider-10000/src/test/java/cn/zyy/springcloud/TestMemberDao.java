package cn.zyy.springcloud;

import cn.zyy.springcloud.dao.MemberDao;
import cn.zyy.springcloud.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Zz
 * @Date: 2023/12/28/22:16
 * @Description:
 *
 * handle error : 注明了@SpringBootTest 该注解,然后test时报错
 *        cause: 测试类的包名要和启动类的包名一致
 *
 *handle error:   测试类启动成功,但是无法向数据库中插入数据
 *       cause:   MemberDao 没有标名 @Mapper 注解,导致启动失败
 */
@SpringBootTest
@Slf4j
public class TestMemberDao {


    @Autowired
    MemberDao memberDao;

    @Test
    public void testInsert(){

        Member member = new Member();
        member.setName("zyy_test_Repository");
        member.setPwd("123456");
        member.setMobile("15102739798");
        member.setEmail("501058587@qq.com");
        member.setGender(1);

        System.out.println(memberDao);
        int i = memberDao.saveMember(member);
        System.out.println(i);

    }


    @Test
    public void testSelect(){
        Member member = memberDao.queryMemberById(1L);
        log.info("查询id=1 的会员信息为:"+member);
    }
}
