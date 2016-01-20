package org.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springmvc.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    @Query(name="User.findAdmins")
    List<User> findAdmins();
}
