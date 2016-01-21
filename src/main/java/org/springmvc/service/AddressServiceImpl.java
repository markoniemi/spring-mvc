package org.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.Address;
import org.springmvc.User;
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
