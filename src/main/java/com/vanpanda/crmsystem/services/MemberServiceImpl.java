package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.builders.Builder;
import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.repositories.MemberRepository;
import com.vanpanda.crmsystem.wrappers.MemberServiceResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    @Qualifier(value = "MemberRepositoryImpl")
    private MemberRepository memberRepository;

    @Autowired
    @Qualifier(value = "BuilderImpl")
    private Builder builder;

    public MemberServiceResult addMember(JSONObject memberParams) {
        if (memberParams.get("id") != null) {
            memberParams.fluentRemove("id");
        }

        long membershipId = -1;
        if (memberParams.get("membership") != null) {
            membershipId = memberParams.getLong("membership");
            memberParams.fluentRemove("membership");
        }

        Member member = builder.buildWithParams(Member.class, memberParams);
        memberRepository.addMember(member);

        MemberServiceResult result = new MemberServiceResult();
        result.setSuccess(true);
        result.setMessage("New member is added");

        return result;
    }

    public MemberServiceResult getMemberById(Long id) {
        MemberServiceResult result = new MemberServiceResult();

        if (id <= 0) {
            result.setSuccess(false);
            result.setMessage("invalid id");
            return result;
        }

        Member member = memberRepository.getMemberById(id);

        if (member == null) {
            result.setMessage("cannot find a member");
            result.setSuccess(false);
        } else {
            result.setMember(member);
            result.setSuccess(true);
        }

        return result;
    }
}
