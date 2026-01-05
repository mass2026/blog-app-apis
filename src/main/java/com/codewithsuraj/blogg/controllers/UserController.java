package com.codewithsuraj.blogg.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.codewithsuraj.blogg.payloads.UserDto;
import com.codewithsuraj.blogg.services.UserServiceImpl;

import jakarta.validation.Valid;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

    @Autowired
    private UserServiceImpl UserService;


    //Post- create user
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)  {
    
        UserDto createdUser = this.UserService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        
    }
    
    
    //Get- get userById
   @GetMapping("/user/{userId}")
   public ResponseEntity<UserDto> getserById(@PathVariable Integer userId){
       UserDto userDto = this.UserService.getUserById(userId);
         return ResponseEntity.ok(userDto);
   }

 
   @GetMapping("/user")
   public ResponseEntity<List<UserDto>> getAllUsers(){
       List<UserDto> users = this.UserService.getAllUsers();
       return ResponseEntity.ok(users);
   }
   
    //Put- update user
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUser = this.UserService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }
                
    //Delete- delete user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable  Integer userId){
        this.UserService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }


}
