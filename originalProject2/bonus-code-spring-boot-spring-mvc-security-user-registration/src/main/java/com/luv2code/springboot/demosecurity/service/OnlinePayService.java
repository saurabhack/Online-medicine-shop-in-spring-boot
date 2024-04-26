package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.entity.OnlinePay;

import java.util.List;

public interface OnlinePayService {

    List<OnlinePay> findAll();

    OnlinePay save(OnlinePay theOnlinePay);
}
