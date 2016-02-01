package org.springmvc.service;

import java.util.List;

import org.springmvc.User;

public interface UserService {
    List<User> findAll();
    User save(User user);
    User findById(long id);
    void delete(long id);
}
