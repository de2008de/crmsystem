package com.vanpanda.crmsystem.repositories;

import com.vanpanda.crmsystem.entities.Member;

public interface PaymentRepository {
    public void addPrepaid(Member member, int amount);
}
