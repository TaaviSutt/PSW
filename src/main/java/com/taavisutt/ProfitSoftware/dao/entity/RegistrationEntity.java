package com.taavisutt.ProfitSoftware.dao.entity;

/**
 * Created by Taavi on 02.06.2017.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
public class RegistrationEntity {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "DateOfBirth")
    public Date dateOfBirth;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    public Date getDateOfBirth() {
        return dateOfBirth;
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



    public RegistrationEntity() {
    }

    public RegistrationEntity(String firstName, String lastName, Date dateOfBirth, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

}
