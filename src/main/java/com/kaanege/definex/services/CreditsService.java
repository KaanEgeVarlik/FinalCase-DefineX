package com.kaanege.definex.services;

import com.kaanege.definex.entities.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditsService {


    public User adjustedUser(User user) {

        int creditLimitMultiplier = 4;
        BigDecimal income = user.getIncome();
        int creditScore = user.getCreditScore();
        BigDecimal deposit = user.getDeposit();
        BigDecimal creditLimit;

        if(creditScore >= 500 && creditScore <= 1000 && income.floatValue() <= 5000){
            user.setResult(true);
            if(deposit.floatValue() > 0){
                user.setCreditLimit(BigDecimal.valueOf((10000 + deposit.floatValue() * 0.1)));
            }else{
                user.setCreditLimit(BigDecimal.valueOf(10000));
            }
        }else if(creditScore >= 500 && creditScore <= 1000 && income.floatValue() <= 10000){
            user.setResult(true);
            if(deposit.floatValue() > 0){
                user.setCreditLimit(BigDecimal.valueOf((20000 + deposit.floatValue() * 0.2)));
            }else{
                user.setCreditLimit(BigDecimal.valueOf(20000));
            }
        }else if(creditScore >= 500 && creditScore <= 1000 && income.floatValue() > 10000){
            user.setResult(true);
            if(deposit.floatValue() > 0){
                user.setCreditLimit(BigDecimal.valueOf(((income.floatValue() * creditLimitMultiplier / 2) + deposit.floatValue() * 0.25)));
            }else{
                user.setCreditLimit(BigDecimal.valueOf(20000));
            }
        }else if(creditScore >= 1000){
            user.setResult(true);
            if(deposit.floatValue() > 0){
                user.setCreditLimit(BigDecimal.valueOf(((income.floatValue() * creditLimitMultiplier) + deposit.floatValue() * 0.5)));
            }else{
                user.setCreditLimit(BigDecimal.valueOf(20000));
            }
        }
        return user;
    }
}
