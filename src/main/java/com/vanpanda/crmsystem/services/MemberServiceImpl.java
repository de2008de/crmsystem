package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.builders.Builder;
import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.repositories.MemberRepository;
import com.vanpanda.crmsystem.wrappers.Result;
import com.vanpanda.crmsystem.wrappers.ResultImpl;

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

    public Result<Member> addMember(JSONObject memberParams) {
        if (memberParams.get("id") != null) {
            memberParams.fluentRemove("id");
        }

        if (memberParams.get("membership") != null) {
            memberParams.fluentRemove("membership");
        }

        Member member = builder.buildWithParams(Member.class, memberParams);
        memberRepository.addMember(member);
        
        Result<Member> result = new ResultImpl<>();
        result.setSuccess(true);
        result.setMessage("New member is added");
        result.setItem(member);

        return result;
    }

    public Result<Member> getMemberById(Long id) {
        Result<Member> result = new ResultImpl<>();

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
            result.setItem(member);
            result.setSuccess(true);
        }

        return result;
    }
}
