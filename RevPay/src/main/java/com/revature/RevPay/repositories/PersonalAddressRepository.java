package com.revature.RevPay.repositories;

import com.revature.RevPay.entities.PersonalAddress;
import com.revature.RevPay.entities.PersonalFinancialAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalAddressRepository extends JpaRepository<PersonalAddress, Integer> {
}
