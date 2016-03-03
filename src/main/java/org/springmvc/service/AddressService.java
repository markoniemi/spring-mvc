package org.springmvc.service;

import org.springmvc.model.Address;
import org.springmvc.model.User;

public interface AddressService {
    Address findByUser(User user);
}
