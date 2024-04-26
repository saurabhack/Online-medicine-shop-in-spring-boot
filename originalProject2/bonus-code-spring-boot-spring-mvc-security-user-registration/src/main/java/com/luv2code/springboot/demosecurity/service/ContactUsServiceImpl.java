package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.dao.ContactUsRepository;
import com.luv2code.springboot.demosecurity.entity.contactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements contactUsService{
    private ContactUsRepository contactUsRepository;
    @Autowired
    public ContactUsServiceImpl(ContactUsRepository theContactUsRepository){
        contactUsRepository=theContactUsRepository;
    }

    @Override
    public List<contactUs> findAll(){
        return contactUsRepository.findAll();

    }

    @Override
    public contactUs save(contactUs theContactUs){
        return contactUsRepository.save(theContactUs);
    }
}
