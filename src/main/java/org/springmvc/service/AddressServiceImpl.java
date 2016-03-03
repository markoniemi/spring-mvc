package org.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.model.Address;
import org.springmvc.model.User;
import org.springmvc.repository.AddressRepository;

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findByUser(User user) {
//        return addressRepository.findOne(user);
        return null;
    }
}
