package cn.zyy.springcloud.service;

import cn.zyy.springcloud.entity.Member;

public interface MemberService {

    public int insertMember(Member member);

    public Member queryMemberById(Long id);
}
