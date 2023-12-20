package com.revature.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;

import java.util.Objects;
import java.util.Set;

@Entity(name = "personal_users")//This class represents an Entity and the table these should be stored in will be called "users"
@Table(indexes = {@Index(columnList = "username")})
public class PersonalUser {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_account",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "account_id") }
    )
    private Set<PersonalFinancialAccount> accounts;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_address",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "address_id") }
    )
    private Set<PersonalAddress> addresses;

    public PersonalUser() {
    }

    public PersonalUser(Integer userId, String firstName, String lastName, String username, String password, String email, String phoneNumber, Set<PersonalFinancialAccount> accounts) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }

    public PersonalUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalUser that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(accounts, that.accounts) && Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, username, password, email, phoneNumber, accounts, addresses);
    }

    public PersonalUser(String firstName, String lastName, String username, String password, String email, String phoneNumber, Set<PersonalFinancialAccount> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }

    public PersonalUser(Integer userId, String firstName, String lastName, String username, String password, String email, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public PersonalUser(String firstName, String lastName, String username, String password, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PersonalFinancialAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<PersonalFinancialAccount> accounts) {
        this.accounts = accounts;
    }

    public Set<PersonalAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<PersonalAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "PersonalUser{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
