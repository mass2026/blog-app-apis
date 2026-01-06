package com.codewithsuraj.blogg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsuraj.blogg.entities.category;

public interface CatagoryRepo extends JpaRepository<category, Integer> {

}
