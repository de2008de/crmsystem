package com.vanpanda.crmsystem.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.services.PaymentService;
import com.vanpanda.crmsystem.wrappers.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {

    @Autowired
    @Qualifier(value = "PaymentServiceImpl")
    private PaymentService paymentService;

    @PostMapping(value = "/prepaid")
    public JSONObject addPrepaid(@RequestBody JSONObject payload) {
        int amountInCent = payload.getIntValue("amountInCent");
        long memberId = payload.getLongValue("memberId");

        Result<Member> result = paymentService.addPrepaid(memberId, amountInCent);

        JSONObject returnJson = new JSONObject();

        returnJson.put("isSuccess", result.isSuccess());
        returnJson.put("message", result.getMessage());
        returnJson.put("data", result.getItem());

        return returnJson;
    }
}
