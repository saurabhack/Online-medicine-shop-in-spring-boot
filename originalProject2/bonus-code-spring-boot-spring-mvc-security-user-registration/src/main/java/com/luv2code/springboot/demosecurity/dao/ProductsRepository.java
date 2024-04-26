package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
