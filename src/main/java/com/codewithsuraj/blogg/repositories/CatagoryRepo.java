package com.codewithsuraj.blogg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsuraj.blogg.entities.Category;

public interface CatagoryRepo extends JpaRepository<Category, Integer> {

}
