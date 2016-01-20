package org.springmvc.service;

import javax.inject.Inject;

import org.springmvc.Address;
import org.springmvc.User;
import org.springmvc.repository.AddressRepository;

public class AddressServiceImpl implements AddressService {
    @Inject
    private AddressRepository addressRepository;

    @Override
    public Address findByUser(User user) {
//        return addressRepository.findOne(user);
        return null;
    }
}
