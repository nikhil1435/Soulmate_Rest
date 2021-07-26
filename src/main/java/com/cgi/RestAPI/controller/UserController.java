package com.cgi.RestAPI.controller;

import com.cgi.RestAPI.model.User;
import com.cgi.RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public  ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "user of "+id+" deleted";
    }

    @PutMapping("/user")
    public ResponseEntity<User> UpdateOrSaveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("users/name/{name}")
    public  ResponseEntity<List<User>> nameSearch(@PathVariable String name){
        return new ResponseEntity<List<User>>((List<User>) userService.nameSearch(name),HttpStatus.OK);
    }

    @GetMapping("users/age/{age}")
    public  ResponseEntity<List<User>> ageSearch(@PathVariable int age){
        return new ResponseEntity<List<User>>((List<User>) userService.ageSearch(age),HttpStatus.OK);
    }

    @GetMapping("users/gender/{gender}")
    public  ResponseEntity<List<User>> genderSearch(@PathVariable String gender){
        return new ResponseEntity<List<User>>((List<User>) userService.genderSearch(gender),HttpStatus.OK);
    }


}
