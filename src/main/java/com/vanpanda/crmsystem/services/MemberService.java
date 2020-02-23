package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.wrappers.Result;

public interface MemberService {
    public Result<Member> addMember(JSONObject memberParams);
    public Result<Member> getMemberById(Long id);
}
