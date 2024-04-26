package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack,Integer> {

}
