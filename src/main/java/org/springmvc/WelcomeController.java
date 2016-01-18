package org.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class WelcomeController {
    @RequestMapping(value = "/api/json/user", method = RequestMethod.GET)
    public @ResponseBody User restTest() {
        User user = new User();
        user.setId(1L);
        user.setName("name");
        user.setEmail("email");
        return user;
    }
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ModelAndView welcome(@PathVariable("name") String name) {
        log.debug("welcome() - name " + name);
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("name", name);
        return model;
    }
}
