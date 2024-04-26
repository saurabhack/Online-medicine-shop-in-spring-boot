package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.OnlinePay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlinePayRepository extends JpaRepository<OnlinePay , Integer> {
}
