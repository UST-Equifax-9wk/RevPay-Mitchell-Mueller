package com.revature.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "personal_financial_accounts")
public class PersonalFinancialAccount {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "balance", nullable = false)
    private Double balance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private PersonalUser user;

    public PersonalFinancialAccount() {
    }

    public PersonalFinancialAccount(Integer accountId, String accountNumber, String type, Double balance, PersonalUser user) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.user = user;
    }

    public PersonalFinancialAccount(String accountNumber, String type, Double balance, PersonalUser user) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.user = user;
    }

    public PersonalFinancialAccount(Integer accountId, String accountNumber, String type, Double balance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }

    public PersonalFinancialAccount(String accountNumber, String type, Double balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public PersonalUser getUser() {
        return user;
    }

    public void setUser(PersonalUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalFinancialAccount that)) return false;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(type, that.type) && Objects.equals(balance, that.balance) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, type, balance, user);
    }

    @Override
    public String toString() {
        return "PersonalFinancialAccount{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
