package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.dao.AddressReoisitory;
import com.luv2code.springboot.demosecurity.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AddressServiceImpl implements AddressService{
    private AddressReoisitory addressRepository;

    @Autowired
    public AddressServiceImpl(AddressReoisitory theAddressRepository){
        addressRepository=theAddressRepository;
    }
    @Override
    public List<Address> findAll(){
        return addressRepository.findAll();
    }
    @Override
    public Address save(Address theAddress){
        return addressRepository.save(theAddress);
    }
}