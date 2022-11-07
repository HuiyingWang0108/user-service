package com.dailycode.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycode.userservice.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    
    @Autowired
    private UserService userService;
}
