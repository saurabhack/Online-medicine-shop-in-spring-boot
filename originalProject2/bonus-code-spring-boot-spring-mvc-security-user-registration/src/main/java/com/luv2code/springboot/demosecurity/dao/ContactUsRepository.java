package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.contactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<contactUs,Integer> {


}
