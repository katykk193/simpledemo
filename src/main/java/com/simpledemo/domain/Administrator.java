package com.simpledemo.domain;

/**
 * Created by vincent on 19/10/16.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
@DiscriminatorValue("ROLE_ADMINISTRATOR")
public class Administrator extends User{

    public Administrator(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

}