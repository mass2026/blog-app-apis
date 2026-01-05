package com.codewithsuraj.blogg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsuraj.blogg.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
