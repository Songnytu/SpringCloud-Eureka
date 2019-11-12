package com.tutu.user.service;

import com.tutu.user.mapper.UserMapper;
import com.tutu.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;  //这里报错就右键如图(不用管)
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
