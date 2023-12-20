package com.revature.RevPay.entities;

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
    @ManyToMany(mappedBy = "accounts")
    private Set<PersonalUser> users;

    public PersonalFinancialAccount() {
    }

    public PersonalFinancialAccount(Integer accountId, String accountNumber, String type, Double balance, Set<PersonalUser> users) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.users = users;
    }

    public PersonalFinancialAccount(String accountNumber, String type, Double balance, Set<PersonalUser> users) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.users = users;
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

    public Set<PersonalUser> getUsers() {
        return users;
    }

    public void setUsers(Set<PersonalUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalFinancialAccount that)) return false;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(type, that.type) && Objects.equals(balance, that.balance) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, type, balance, users);
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
