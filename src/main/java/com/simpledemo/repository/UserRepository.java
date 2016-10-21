package com.simpledemo.repository;

import com.simpledemo.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vincent on 19/10/16.
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}