package com.vanpanda.crmsystem.services;

import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.wrappers.Result;

public interface PaymentService {
    public Result<Member> addPrepaid(long memberId, int amount);
}
