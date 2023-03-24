package com.tim.spring_security.service;

import com.tim.spring_security.config.PasswordConfig;
import com.tim.spring_security.dao.UserDao;
import com.tim.spring_security.model.Role;
import com.tim.spring_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;

//    private final PasswordConfig passwordConfig;
private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordConfig passwordConfig, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
//        this.passwordConfig = passwordConfig;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void add(User user, Set<Role> roles) {
//        user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDao.add(user, roles);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User change(User user, Set<Role> roles) {
//        user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.change(user, roles);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findUserByName(username);
    }
}