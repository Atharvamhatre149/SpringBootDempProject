package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/user")
    public String createNewEmployee(@RequestBody User user){
        userRepo.save(user);
        return "Employee Created in database";
    }

    @GetMapping("/user")

    public ResponseEntity<List<User>> getAllUser()
    {   
        List<User> userlist= new ArrayList<>();
        userRepo.findAll().forEach(userlist::add);
        return new ResponseEntity<List<User>>(userlist,HttpStatus.OK);
    }

}
