package org.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmvc.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
