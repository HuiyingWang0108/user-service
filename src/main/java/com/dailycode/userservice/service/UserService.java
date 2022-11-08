package com.dailycode.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycode.userservice.VO.ResponseTemplateVO;
import com.dailycode.userservice.entity.User;
import com.dailycode.userservice.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        // get User by findById(userId)
        Optional<User> optional = userRepository.findById(userId);
        optional.ifPresent(user -> {
            responseTemplateVO.setUser(user);
        });

        // get Department by RestTemplate

        return responseTemplateVO;
    }

  

}
