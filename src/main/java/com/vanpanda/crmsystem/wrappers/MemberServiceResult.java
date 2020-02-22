package com.vanpanda.crmsystem.wrappers;

import com.vanpanda.crmsystem.entities.Member;

public class MemberServiceResult extends Result {
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
