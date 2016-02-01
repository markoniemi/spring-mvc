package org.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmvc.User;
import org.springmvc.repository.UserRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Controller
@RequestMapping(value = "/api/rest/users")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
//    @RequestMapping(consumes = {"text/plain", "application/*"})
    public @ResponseBody List<User> findAll() {
        log.debug("findAll");
        return userRepository.findAll();
    }

    public User save(User user) {
        if (user.getId() != null) {
        	//edit existing
            User tempUser = userRepository.findOne(user.getId());
            log.debug("found existing user: " + tempUser);
            tempUser.setUsername(user.getUsername());
            tempUser.setName(user.getName());
            tempUser.setEmail(user.getEmail());
            tempUser.setAddress(user.getAddress());
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

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
