package com.revature.RevPay.services;

import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.repositories.PersonalUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class PersonalUserService {

    private final PersonalUserRepository personalUserRepository;

    @Autowired
    public PersonalUserService(PersonalUserRepository personalUserRepository) {
        this.personalUserRepository = personalUserRepository;
    }

    public PersonalUser saveOrUpdate(PersonalUser personalUser) {return personalUserRepository.save(personalUser);}
}
