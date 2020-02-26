package com.vanpanda.crmsystem.services;

import com.alibaba.fastjson.JSONObject;
import com.vanpanda.crmsystem.builders.Builder;
import com.vanpanda.crmsystem.entities.User;
import com.vanpanda.crmsystem.repositories.UserRepository;
import com.vanpanda.crmsystem.wrappers.Result;
import com.vanpanda.crmsystem.wrappers.ResultImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {
    
    @Autowired
    @Qualifier(value = "UserRepositoryImpl")
    private UserRepository userRepository;

    @Autowired
    @Qualifier(value = "EncryptionServiceImpl")
    private EncryptionService encryptionService;

    @Autowired
    @Qualifier(value = "BuilderImpl")
    private Builder builder;

    public Result<User> addUser(JSONObject userParams) {
        Result<User> result = new ResultImpl<>();
        String password = userParams.getString("password");
        
        if (password == null || password.length() == 0) {

            result.setSuccess(false);
            result.setMessage("password is required");

            return result;

        }

        String salt = encryptionService.generateSalt();
        String encryptedPassword = encryptionService.encrypt(password, salt);

        userParams.put("password", encryptedPassword);
        userParams.put("salt", salt);

        User user = builder.buildWithParams(User.class, userParams);
        userRepository.addUser(user);

        result.setSuccess(true);
        result.setMessage("new user is added");
        result.setItem(user);

        return result;
    }

    public Result<User> getUserById(long id) {
        Result<User> result = new ResultImpl<>();

        if (id <= 0) {

            result.setSuccess(false);
            result.setMessage("invalid id");

            return result;
        }

        User user = userRepository.getUserById(id);

        if (user == null) {

            result.setSuccess(false);
            result.setMessage("cannot find a user");

            return result;
        }

        result.setSuccess(true);
        result.setItem(user);

        return result;
    }
}
