package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.dao.CardDetailsRepository;
import com.luv2code.springboot.demosecurity.entity.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardDetailsServiceImpl implements CardDetailsService{

    private CardDetailsRepository cardDetailsRepository;
    @Autowired
    public CardDetailsServiceImpl(CardDetailsRepository theCardDetailsRepository){
        cardDetailsRepository=theCardDetailsRepository;
    }
    @Override
    public List<CardDetails> findAll() {
        return cardDetailsRepository.findAll();
    }

    @Override
    public CardDetails save(CardDetails theCardDetails) {
        return cardDetailsRepository.save(theCardDetails);
    }
}
