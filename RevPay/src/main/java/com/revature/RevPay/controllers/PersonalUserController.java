package com.revature.RevPay.controllers;

import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.exceptions.AccessDeniedException;
import com.revature.RevPay.exceptions.NoResultsException;
import com.revature.RevPay.exceptions.UsernameUnavailableException;
import com.revature.RevPay.repositories.PersonalUserRepository;
import com.revature.RevPay.services.PersonalUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PersonalUserController {

    private final PersonalUserService personalUserService;

    @Autowired
    public PersonalUserController(PersonalUserService personalUserService) {
        this.personalUserService = personalUserService;
    }
    @PostMapping(path = "/personal_users")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    PersonalUser postNewUser(@RequestBody PersonalUser personalUser){return personalUserService.saveOrUpdate(personalUser);}

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin
    public PersonalUser registerUser(@RequestBody PersonalUser personalUser, HttpServletResponse response) throws UsernameUnavailableException {
        return personalUserService.registerUser(personalUser);
    }

    @GetMapping(path = "/personal_users/{username}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    PersonalUser getUserByUsername(@PathVariable String username) throws NoResultsException {
        return personalUserService.findByUsername(username);
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonalUser authenticate(@RequestBody PersonalUser personalUser, HttpServletResponse response) throws AccessDeniedException {
        if(this.personalUserService.authenticate(personalUser)){
            try {
                Cookie cookie = new Cookie("username", personalUser.getUsername());
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                response.addCookie(cookie);
                return personalUserService.findByUsername(personalUser.getUsername());
            } catch (NoResultsException e) {
                throw new AccessDeniedException("Access denied");
            }
        } else {
            throw new AccessDeniedException("Access denied");
        }
    }


}
