package org.springmvc;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
    @Autowired
    @Qualifier("userServiceBean")
    private UserService userService;
    
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserForm userForm) {
        // TODO clean up, is this a good implementation?
        log.debug("save() - userForm: {}", userForm);
        User user = new User();
        if (userForm.getId() != null) {
            user.setId(userForm.getId());
        }
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user = userService.save(user);
        log.debug("save() - saved user: {}", user);
        return "redirect:/user/users";
    }
//    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
//    public ModelAndView updateUser(@ModelAttribute UserForm userForm) {
//        log.debug("update() - userForm: {}", userForm);
//        ModelAndView model = new ModelAndView();
//        model.setViewName("/user/users");
//        model.addObject("userForm", userForm);
//        return model;
//    }
//    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
//    public ModelAndView newUser() {
//        UserForm userForm = new UserForm();
//        log.debug("newUser() - userForm: {}", userForm);
//        ModelAndView model = new ModelAndView();
//        model.setViewName("/user/user");
//        model.addObject("userForm", userForm);
//        return model;
//    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable long id) {
        // TODO use userForm instead of user
        User user = userService.findById(id);
        log.debug("editUser() - found user: {}", user);
        if (user == null) {
            user = new User();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("/user/user");
        model.addObject("userForm", user);
        return model;
    }
}
