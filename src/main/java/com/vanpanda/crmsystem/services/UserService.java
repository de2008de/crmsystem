package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.entities.User;
import com.vanpanda.crmsystem.wrappers.Result;

public interface UserService {
    public Result<User> addUser(JSONObject userParams);
    public Result<User> getUserById(long id);
}
