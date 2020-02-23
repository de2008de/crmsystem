package com.vanpanda.crmsystem.services;

import com.vanpanda.crmsystem.entities.Member;
import com.vanpanda.crmsystem.repositories.PaymentRepository;
import com.vanpanda.crmsystem.wrappers.Result;
import com.vanpanda.crmsystem.wrappers.ResultImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    @Qualifier(value = "PaymentRepositoryImpl")
    private PaymentRepository paymentRepository;

    @Autowired
    @Qualifier(value = "MemberServiceImpl")
    private MemberService memberService;

    public Result<Member> addPrepaid(long memberId, int amount) {
        Result<Member> result = new ResultImpl<>();

        if (amount <= 0) {
            result.setSuccess(false);
            result.setMessage("Amount must be greater than zero");
            return result;
        }

        Result<Member> memberResult = memberService.getMemberById(memberId);
        
        if (!memberResult.isSuccess()) {
            result.setSuccess(false);
            result.setMessage(memberResult.getMessage());
            return result;
        }

        Member member = memberResult.getItem();
        paymentRepository.addPrepaid(member, amount);

        result.setSuccess(true);
        result.setItem(member);
        return result;
    }
}
