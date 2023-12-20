package com.revature.RevPay.controllers;

import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.repositories.PersonalUserRepository;
import com.revature.RevPay.services.PersonalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonalUserController {

    private final PersonalUserService personalUserService;

    @Autowired
    public PersonalUserController(PersonalUserService personalUserService) {
        this.personalUserService = personalUserService;
    }
    @PostMapping(path = "/personal_users")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    PersonalUser registerNewUser(@RequestBody PersonalUser personalUser){return personalUserService.saveOrUpdate(personalUser);}


}
