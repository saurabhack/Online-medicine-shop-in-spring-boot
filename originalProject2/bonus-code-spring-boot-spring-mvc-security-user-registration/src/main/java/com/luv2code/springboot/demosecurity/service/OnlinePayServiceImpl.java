package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.dao.OnlinePayRepository;
import com.luv2code.springboot.demosecurity.entity.OnlinePay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OnlinePayServiceImpl implements OnlinePayService {

    private OnlinePayRepository onlinePayRepository;

    @Autowired
    public OnlinePayServiceImpl(OnlinePayRepository theOnlinePayRepository){
        onlinePayRepository=theOnlinePayRepository;
    }

    @Override
    public List<OnlinePay> findAll() {
        return onlinePayRepository.findAll();
    }

    @Override
    public OnlinePay save(OnlinePay theOnlinePay) {
        return onlinePayRepository.save(theOnlinePay);
    }
}
