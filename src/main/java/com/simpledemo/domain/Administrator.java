package com.simpledemo.domain;

/**
 * Created by vincent on 19/10/16.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
@DiscriminatorValue("A")
public class Administrator extends User{

    public Administrator() {}
    public Administrator(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setType("ROLE_ADMINISTRATOR");
        this.setEnabled(1);
    }

}