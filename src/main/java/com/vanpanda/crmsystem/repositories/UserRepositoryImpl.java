package com.vanpanda.crmsystem.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.vanpanda.crmsystem.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier(value = "UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
