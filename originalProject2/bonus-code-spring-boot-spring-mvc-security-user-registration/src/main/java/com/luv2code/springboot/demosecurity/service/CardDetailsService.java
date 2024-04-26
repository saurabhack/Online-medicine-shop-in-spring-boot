package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.entity.Address;
import com.luv2code.springboot.demosecurity.entity.CardDetails;

import java.util.List;

public interface CardDetailsService {

    List<CardDetails> findAll();
    CardDetails save(CardDetails theCardDetails);
}
