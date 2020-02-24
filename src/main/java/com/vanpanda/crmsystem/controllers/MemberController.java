package com.vanpanda.crmsystem.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.services.MemberService;
import com.vanpanda.crmsystem.wrappers.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/member")
public class MemberController {
    
    @Autowired
    @Qualifier(value = "MemberServiceImpl")
    private MemberService memberService;
    
    @GetMapping(value = "/{id}")
    public JSONObject getMemberById(@PathVariable long id) {
        Result<Member> result = memberService.getMemberById(id);
        JSONObject returnJson = new JSONObject();

        returnJson.put("isSuccess", result.isSuccess());

        if (result.isSuccess()) {
            Member member = result.getItem();
            returnJson.put("data", member);
        } else {
            returnJson.put("data", null);
            returnJson.put("message", result.getMessage());
        }

        return returnJson;
    }

    @PostMapping
    public JSONObject addMember(@RequestBody JSONObject payload) {
        Result<Member> result = memberService.addMember(payload);
        JSONObject returnJson = new JSONObject();

        Member member = result.getItem();
        returnJson.put("data", member);

        returnJson.put("isSuccess", result.isSuccess());
        returnJson.put("message", result.getMessage());

        return returnJson;
    }

}
