package org.springmvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("UserControllerTest.xml")
@Log4j
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void newUser() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user/new");
        ResultActions resultActions = mockMvc.perform(request);

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/pages/user/user.jsp"));
        ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
        User user = (User) modelAndView.getModel().get("user");
        Assert.assertNotNull(user);

        // fill user form
        new User();
        user.setName("name");
        user.setUsername("username");
        user.setEmail("email");
        request = MockMvcRequestBuilders.post("/user/save").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("userForm", user);
        resultActions = mockMvc.perform(request);
        resultActions.andExpect(MockMvcResultMatchers.redirectedUrl("/user/users"));
    }
}
