package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReoisitory extends JpaRepository<Address, Integer> {


}
