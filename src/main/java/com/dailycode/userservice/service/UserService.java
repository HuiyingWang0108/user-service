package com.dailycode.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycode.userservice.VO.Department;
import com.dailycode.userservice.VO.ResponseTemplateVO;
import com.dailycode.userservice.entity.User;
import com.dailycode.userservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        // get User by findById(userId)
        Optional<User> optional = userRepository.findById(userId);
        optional.ifPresent(user -> {

            responseTemplateVO.setUser(user);

            // get Department by RestTemplate
            Department department = restTemplate
                    .getForObject("http://DEPARTMENT-SERVICE/v1/departments/"//http://localhost:9001/v1/departments/
                            + user.getDepartmentId(), Department.class);
            responseTemplateVO.setDepartment(department);
        });

        return responseTemplateVO;
    }

}
