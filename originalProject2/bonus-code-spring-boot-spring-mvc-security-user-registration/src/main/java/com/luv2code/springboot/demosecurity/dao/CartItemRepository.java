package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.CartItem;
import com.luv2code.springboot.demosecurity.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    CartItem findByProducts(Products product);


}
