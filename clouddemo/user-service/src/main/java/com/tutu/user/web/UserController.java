package com.tutu.user.web;

import com.tutu.user.pojo.User;
import com.tutu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")  //请求地址localhost:8081/user/5     5就是id
    public User queryById(@PathVariable("id") Long id){   //接收参数
        return userService.queryById(id);
    }
}
