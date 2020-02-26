package com.vanpanda.crmsystem.controllers;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.User;
import com.vanpanda.crmsystem.services.UserService;
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
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    @Qualifier(value = "UserServiceImpl")
    private UserService userService;

    @GetMapping(value = "{id}")
    public JSONObject getUserById(@PathVariable long id) {
        Result<User> result = userService.getUserById(id);
        JSONObject returnJson = new JSONObject();

        User user = result.getItem();
        returnJson.put("data", user);

        returnJson.put("isSuccess", result.isSuccess());
        returnJson.put("message", result.getMessage());

        return returnJson;
    }

    @PostMapping
    public JSONObject addUser(@RequestBody JSONObject payload) {
        Result<User> result = userService.addUser(payload);
        JSONObject returnJson = new JSONObject();

        User user = result.getItem();
        returnJson.put("data", user);

        returnJson.put("isSuccess", result.isSuccess());
        returnJson.put("message", result.getMessage());

        return returnJson;
    }
}
