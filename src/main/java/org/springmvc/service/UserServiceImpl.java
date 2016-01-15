package org.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springmvc.User;

/**
 * UserService should really persist to DB.
 */
@Service
@Slf4j
@WebService(endpointInterface = "org.springmvc.service.UserService", serviceName = "userService")
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<User>();
    private static long id;

    public List<User> findAll() {
        log.info("findAll");
        return users;
    }

    public User save(User user) {
        if (user.getId() != null) {
            User tempUser = findById(user.getId());
            tempUser.setName(user.getName());
            tempUser.setEmail(user.getEmail());
            return tempUser;
        }else {
            user.setId(id++);
            users.add(user);
            return user;
        }
    }

    @Override
    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
