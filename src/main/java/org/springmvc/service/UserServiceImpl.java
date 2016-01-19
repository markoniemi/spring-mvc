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
    @Inject
    private UserRepository userRepository;


    public List<User> findAll() {
        log.debug("findAll");
        return userRepository.findAll();
    }

    public User save(User user) {
        if (user.getId() != null) {
        	//edit existing
            User tempUser = userRepository.findOne(user.getId());
            log.debug("found existing user: " + tempUser);
            tempUser.setName(user.getName());
            tempUser.setEmail(user.getEmail());
            userRepository.save(tempUser);
            
            return tempUser;
        } else {
        	//new user
            userRepository.save(user);
            
            return user;
        }
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }
}
