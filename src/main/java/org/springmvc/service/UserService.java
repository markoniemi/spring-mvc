package org.springmvc.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Service;
import org.springmvc.User;

@Service
@WebService
@Path("users")
public interface UserService {
    @GET
    List<User> findAll();
    User save(User user);
    User findById(long id);
    void delete(long id);
}
