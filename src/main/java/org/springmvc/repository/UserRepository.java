package org.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmvc.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
