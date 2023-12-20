package com.revature.RevPay.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name = "personal_address")
public class PersonalAddress {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @ManyToMany(mappedBy = "addresses")
    private Set<PersonalUser> users;

    public PersonalAddress() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
        if (!(o instanceof PersonalAddress that)) return false;
        return Objects.equals(addressId, that.addressId) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(zipCode, that.zipCode) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, street, city, country, zipCode, users);
    }

    @Override
    public String toString() {
        return "PersonalAddress{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
