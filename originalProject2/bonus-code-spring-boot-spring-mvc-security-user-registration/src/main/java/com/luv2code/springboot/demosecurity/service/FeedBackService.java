package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.entity.FeedBack;

import java.util.List;

public interface FeedBackService {
        List<FeedBack> findAll();
        FeedBack save(FeedBack theFeedBack);

}
