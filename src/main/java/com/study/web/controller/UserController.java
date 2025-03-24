package com.study.web.controller;


import com.study.web.entity.User;
import com.study.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public User queryUser(@RequestParam("UID") Integer UID) {
        // check uid is not null
        if (null == UID) {
            // is UID is null
            return null;
        }
        // check information
        User user = userService.queryUserInformation(UID);
        //
        if (null == user) {
            return null;
        }
        return user;
    }
}
