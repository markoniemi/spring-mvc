package org.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UserController {
    @Autowired
    @Qualifier("userServiceBean")
    private UserService userService;

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserForm userForm) {
        // TODO clean up, is this a good implementation?
        log.debug("save() - userForm: " + userForm);
        User user = new User();
        if (userForm.getId() != null) {
            user.setId(userForm.getId());
        }
        user.setUsername(userForm.getUsername());
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setRole(userForm.getRole());
        user.setAddress(userForm.getAddress());
        user = userService.save(user);
        log.debug("save() - saved user: " + user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public ModelAndView newUser() {
        return editUser(-1L);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable long id) {
        // TODO use userForm instead of user
        User user = userService.findById(id);
        log.debug("editUser() - found user: " + user);
        if (user == null) {
            user = new User();
            user.setAddress(new Address());
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("/user/user");
        model.addObject("userForm", user);
        return model;
    }
}
