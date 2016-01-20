package org.springmvc.service;

import org.springmvc.Address;
import org.springmvc.User;

public interface AddressService {
    Address findByUser(User user);
}
