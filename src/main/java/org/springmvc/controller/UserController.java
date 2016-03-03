package org.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.model.Address;
import org.springmvc.model.User;
import org.springmvc.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UserController {
    @Autowired
//    @Qualifier("userServiceBean")
    private UserService userService;

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        User savedUser = userService.save(user);
        log.debug("save() - saved user: " + savedUser);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public ModelAndView newUser() {
        return editUser(-1L);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable long id) {
        User user = userService.findById(id);
        log.debug("editUser() - found user: " + user);
        if (user == null) {
            user = new User();
            user.setAddress(new Address());
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("user/user");
        model.addObject("user", user);
        return model;
    }
    
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/user/users";
    }
    
}
