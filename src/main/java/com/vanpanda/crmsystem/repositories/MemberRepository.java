package com.vanpanda.crmsystem.repositories;

import com.vanpanda.crmsystem.entities.Member;

public interface MemberRepository {
    public void addMember(Member member);
    public Member getMemberById(Long id);
}
