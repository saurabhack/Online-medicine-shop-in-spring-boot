package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.entity.contactUs;

import java.util.List;

public interface contactUsService {
    List<contactUs> findAll();

    contactUs save(contactUs theContactUs);
}
