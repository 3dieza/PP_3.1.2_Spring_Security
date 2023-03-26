package com.tim.spring_security.service;

import com.tim.spring_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> findRoles(List<Long> roles);

    List<Role> getAllRoles();
}