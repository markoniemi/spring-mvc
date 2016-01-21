package org.springmvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springmvc.Address;
import org.springmvc.User;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config-datasource-test.xml", inheritLocations = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("UserRepositoryIT.xml")
@Log4j
@Transactional
public class UserRepositoryIT {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
        Assert.assertEquals("name1", users.get(0).getName());
        log.debug(users);
        Assert.assertNotNull(users.get(2).getAddress());
        Assert.assertEquals("streetAddress1", users.get(2).getAddress().getStreetAddress());
    }

    @Test
    public void findByUsername() {
        User user = userRepository.findByUsername("username2");
        Assert.assertEquals("username2", user.getUsername());
        log.debug(user);
    }

    @Test
    public void findAdmins() {
        List<User> users = userRepository.findAdmins();
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        Assert.assertEquals("name2", users.get(0).getName());
        log.debug(users);
    }

//    @Rollback(false)
    @Test
    public void save() {
        User user = new User("name", "username", "admin", "email");
        Address address = new Address("streetAddress");
        user.setAddress(address);
        User savedUser = userRepository.save(user);
        savedUser = userRepository.findOne(savedUser.getId());
        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser.getId());
        Assert.assertNotNull(savedUser.getAddress());
        Assert.assertNotNull(savedUser.getAddress().getId());
        log.debug(savedUser);
    }
    
//    @Rollback(false)
    @Test
    public void delete() {
        User user = userRepository.findOne(1L);
        userRepository.delete(user);
        Assert.assertNull(userRepository.findOne(1L));
        user = userRepository.findOne(3L);
        Assert.assertNotNull(user.getAddress());
        userRepository.delete(3L);
        Assert.assertNull(userRepository.findOne(3L));
        List<User> users = userRepository.findAll();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(0, addressRepository.findAll().size());
    }
}
