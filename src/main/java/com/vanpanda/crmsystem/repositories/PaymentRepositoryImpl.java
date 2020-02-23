package com.vanpanda.crmsystem.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.vanpanda.crmsystem.entities.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier(value = "PaymentRepositoryImpl")
public class PaymentRepositoryImpl implements PaymentRepository {

    @Autowired
    private EntityManager entityManager;

    public void addPrepaid(Member member, int amount) {
        member.addPrepaidInCent(amount);

        entityManager.persist(member);
        entityManager.flush();
    }
}
