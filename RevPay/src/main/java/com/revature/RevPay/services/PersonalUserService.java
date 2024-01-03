package com.revature.RevPay.services;

import com.revature.RevPay.entities.PersonalUser;
import com.revature.RevPay.exceptions.NoResultsException;
import com.revature.RevPay.exceptions.UsernameUnavailableException;
import com.revature.RevPay.repositories.PersonalUserRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class PersonalUserService {

    private final PersonalUserRepository personalUserRepository;

    @Autowired
    public PersonalUserService(PersonalUserRepository personalUserRepository) {
        this.personalUserRepository = personalUserRepository;
    }

    public PersonalUser saveOrUpdate(PersonalUser personalUser) {return personalUserRepository.save(personalUser);}

    public PersonalUser findByUsername(String username) throws NoResultsException {
        Optional<PersonalUser> result = personalUserRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new NoResultsException("No results for username: " + username);
        }
        return result.get();
    }

    public boolean checkUsername(String username) {
        Optional<PersonalUser> userOptional = personalUserRepository.findByUsername(username);
        return userOptional.isPresent();
    }

    @Transactional
    public PersonalUser registerUser(PersonalUser newUser) throws UsernameUnavailableException {
        if(!this.checkUsername(newUser.getUsername())) {
            newUser.setPassword(this.hash(newUser.getPassword()));
            return this.saveOrUpdate(newUser);
        }
        throw new UsernameUnavailableException("This username is not available");
    }

    public String hash(String text) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(text, salt);
    }

    public boolean checkHash(String text, String hash) {
        return BCrypt.checkpw(text, hash);
    }

    public boolean authenticate(PersonalUser personalUser) {
        Optional<PersonalUser> candidate = this.personalUserRepository.findByUsername(personalUser.getUsername());
        return candidate.filter(user -> this.checkHash(personalUser.getPassword(), user.getPassword())).isPresent();
    }
}
