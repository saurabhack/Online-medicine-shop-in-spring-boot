package com.luv2code.springboot.demosecurity.dao;


import com.luv2code.springboot.demosecurity.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepository extends JpaRepository<CardDetails,Integer> {

}
