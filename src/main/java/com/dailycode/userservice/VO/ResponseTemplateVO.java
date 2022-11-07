package com.dailycode.userservice.VO;

import com.dailycode.userservice.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    
    private User user;
    private Department department;
}
