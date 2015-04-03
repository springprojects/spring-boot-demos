package com.gaodashang.demo.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * comments.
 *
 * @author eva
 */
@Entity
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.userName = ?1")
public class User extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String userName;

    private String firstName;
    private String lastName;

    public User() {
        this(null);
    }

    public User(Long id) {
        this.setId(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
