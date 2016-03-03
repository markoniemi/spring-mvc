package org.springmvc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springmvc.controller.UserControllerTest;
import org.springmvc.repository.UserRepositoryTest;
import org.springmvc.service.UserServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    UserControllerTest.class,
    UserRepositoryTest.class,
    UserServiceTest.class
})
public class SpringMvcUnitTestSuite {

}
