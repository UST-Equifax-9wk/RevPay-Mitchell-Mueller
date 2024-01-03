package com.revature.RevPay.controllers;

import com.revature.RevPay.entities.PersonalFinancialAccount;
import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.exceptions.NoResultsException;
import com.revature.RevPay.services.PersonalFinancialAccountService;
import com.revature.RevPay.services.PersonalUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PersonalFinancialAccountController {

    private final PersonalFinancialAccountService personalFinancialAccountService;
    private final PersonalUserService personalUserService;

    @Autowired
    public PersonalFinancialAccountController(PersonalFinancialAccountService personalFinancialAccountService, PersonalUserService personalUserService){
        this.personalFinancialAccountService = personalFinancialAccountService;
        this.personalUserService = personalUserService;
    }

    @PostMapping(path = "/personal_users/{username}/account")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    PersonalFinancialAccount postNewAccount(@PathVariable String username, @RequestBody PersonalFinancialAccount personalFinancialAccount) throws NoResultsException
    {
        PersonalUser user = personalUserService.findByUsername(username);
        personalFinancialAccount.setUser(user);
        return personalFinancialAccountService.saveOrUpdate(personalFinancialAccount);
    }

    @PostMapping(path = "/add_account")
    @ResponseStatus(HttpStatus.ACCEPTED)
    PersonalFinancialAccount addAccount(@RequestBody PersonalFinancialAccount personalFinancialAccount, HttpServletResponse response)
    {
        return personalFinancialAccountService.addAccount(personalFinancialAccount);
    }

    @PostMapping(path = "/personal_users/{username}/send/{target}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    void sendMoneyByUsername(@PathVariable String target, @PathVariable double amount, @PathVariable String username){
        personalFinancialAccountService.sendMoneyByUsername(target, amount);
    }
}
