package com.dailycode.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycode.userservice.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository; 
}
