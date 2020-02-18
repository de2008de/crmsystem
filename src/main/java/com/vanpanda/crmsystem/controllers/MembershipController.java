package com.vanpanda.crmsystem.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.Membership;
import com.vanpanda.crmsystem.services.MembershipService;

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
@RequestMapping(value = "/api/v1/membership")
public class MembershipController {

    @Autowired
    @Qualifier("MembershipServiceImpl")
    private MembershipService membershipService;

    @GetMapping(value = "/{id}")
    public JSONObject getMembershipById(@PathVariable Long id) {
        JSONObject returnJson = new JSONObject();
        Membership membership = membershipService.getMembershipById(id);
        returnJson.put("data", membership);

        return returnJson;
    }

    @PostMapping
    public JSONObject addMembership(@RequestBody JSONObject payload) {
        Membership membership = new Membership();
        JSONObject returnJson = new JSONObject();

        membership.setName(payload.getString("name"));
        membership.setDescription(payload.getString("description"));
        membershipService.addMembership(membership);

        String message = "success";
        returnJson.put("message", message);

        return returnJson;
    }
}
