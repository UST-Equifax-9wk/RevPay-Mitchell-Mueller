package com.revature.RevPay.services;

import com.revature.RevPay.entities.PersonalFinancialAccount;
import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.repositories.PersonalFinancialAccountRepository;
import com.revature.RevPay.repositories.PersonalUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class PersonalFinancialAccountService {

    private final PersonalFinancialAccountRepository personalFinancialAccountRepository;
    private final PersonalUserRepository personalUserRepository;
    @Autowired
    public PersonalFinancialAccountService(PersonalFinancialAccountRepository personalFinancialAccountRepository, PersonalUserRepository personalUserRepository)
    {
        this.personalFinancialAccountRepository = personalFinancialAccountRepository;
        this.personalUserRepository = personalUserRepository;
    }

    public PersonalFinancialAccount saveOrUpdate(PersonalFinancialAccount personalFinancialAccount) {
        return personalFinancialAccountRepository.save(personalFinancialAccount);
    }

    @Transactional
    public PersonalFinancialAccount addAccount(PersonalFinancialAccount personalFinancialAccount){
        return this.saveOrUpdate(personalFinancialAccount);
    }

    public void sendMoneyByUsername(String username, double amount){
        PersonalUser user = this.personalUserRepository.findByUsername(username).get();
        PersonalFinancialAccount account = user.getAccount();
        double balance = account.getBalance();
        balance += amount;
        account.setBalance(balance);

    }
}
