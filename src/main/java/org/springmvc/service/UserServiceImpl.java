package org.springmvc.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import org.springframework.stereotype.Service;
import org.springmvc.User;
import org.springmvc.repository.UserRepository;

import lombok.extern.log4j.Log4j;

/**
 * UserService should really persist to DB.
 */
@Service
@Log4j
@WebService(endpointInterface = "org.springmvc.service.UserService", serviceName = "userService")
public class UserServiceImpl implements UserService {
//    private List<User> users = new ArrayList<User>();
    private static long id;
    @Inject
    private UserRepository userRepository;

    public List<User> findAll() {
        log.info("findAll");
        return userRepository.findAll();
    }

    public User save(User user) {
        if (user.getId() != null) {
//            User tempUser = findById(user.getId());
            User tempUser = userRepository.findOne(user.getId());
            tempUser.setName(user.getName());
            tempUser.setEmail(user.getEmail());
            return tempUser;
        }else {
//            user.setId(id++);
            userRepository.save(user);
//            users.add(user);
            return user;
        }
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
    }
}
