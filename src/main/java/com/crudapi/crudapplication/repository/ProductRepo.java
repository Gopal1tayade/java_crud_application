package com.crudapi.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapi.crudapplication.entity.Product;

public interface ProductRepo extends JpaRepository <Product,Integer>{

}
