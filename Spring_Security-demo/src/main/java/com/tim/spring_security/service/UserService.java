package com.tim.spring_security.service;

import com.tim.spring_security.model.Role;
import com.tim.spring_security.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user, Set<Role> roles);

    void delete(long id);

    User change(User user, Set<Role> roles);

    List<User> listUsers();

    User findUserById(long id);

    User findUserByName(String name);
}