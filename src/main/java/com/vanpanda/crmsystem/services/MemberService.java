package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.wrappers.MemberServiceResult;

public interface MemberService {
    public MemberServiceResult addMember(JSONObject memberParams);
    public MemberServiceResult getMemberById(Long id);
}
