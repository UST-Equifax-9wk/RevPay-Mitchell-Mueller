package com.revature.RevPay.repositories;

import com.revature.RevPay.entities.PersonalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalUserRepository extends JpaRepository<PersonalUser, Integer> {
}
