package com.csis231.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Client_id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<workout> workouts;

    @OneToMany(mappedBy = "client")
    private List<Exercise> exercises;

    @NotEmpty(message = "First name cannot be empty")
    @Column(name="Client_first_name", nullable = false)
    private String firstName;
    @Column(name="Client_last_name")
    private String lastName;

    @NotEmpty(message = "username name cannot be empty")
    @Column(name="Username", nullable = false, unique = true)
    private String userName;

    @NotEmpty(message = "Password name cannot be empty")
    @Column(name="Password", nullable = false)
    private String password;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString()
    {
        return "Client [id=" +id+", firstName=" +firstName+ "lastName=" +lastName+ "username=" +userName + "password=" +password+ "]";
    }

}
