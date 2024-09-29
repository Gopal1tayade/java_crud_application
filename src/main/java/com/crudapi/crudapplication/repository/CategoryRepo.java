package com.crudapi.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapi.crudapplication.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
