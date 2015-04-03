package com.gaodashang.demo.domain;

import javax.persistence.*;

/**
 * comments.
 *
 * @author eva
 */
@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    static enum Gender {
        MALE, FEMALE;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
