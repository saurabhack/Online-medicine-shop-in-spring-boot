package com.luv2code.springboot.demosecurity.service;
import com.luv2code.springboot.demosecurity.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address save(Address theAddress);
}
