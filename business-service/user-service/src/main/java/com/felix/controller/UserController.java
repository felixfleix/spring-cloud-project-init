package com.felix.controller;

import com.felix.domain.entity.UserInfo;
import com.felix.domain.service.UserService;
import com.felix.response.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    public SingleResponse<Boolean> add(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "age") Integer age) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        return SingleResponse.success(userService.save(userInfo));
    }

}
