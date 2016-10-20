package com.simpledemo.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
@DiscriminatorValue("L")
public class Lecturer extends User {

    public Lecturer(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setType("ROLE_LECTURER");
        this.setEnabled(1);
    }
}


/*
@Entity
@Table(name="LECTURER")
public class Lecturer {

    @Id
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
*/