package com.vanpanda.crmsystem.repositories;

import com.vanpanda.crmsystem.entities.User;

public interface UserRepository {
    public void addUser(User user);
    public User getUserById(long id);
}
