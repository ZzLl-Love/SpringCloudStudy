package cn.zyy.springcloud.service.impl;

import cn.zyy.springcloud.dao.MemberDao;
import cn.zyy.springcloud.entity.Member;
import cn.zyy.springcloud.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    MemberDao memberDao;

    @Override
    public int insertMember(Member member) {

         return memberDao.saveMember(member);

    }

    @Override
    public Member queryMemberById(Long id) {

        return memberDao.queryMemberById(id);
    }
}
