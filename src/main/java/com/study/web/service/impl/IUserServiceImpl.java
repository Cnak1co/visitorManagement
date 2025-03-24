package com.study.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.web.entity.User;
import com.study.web.mapper.UserMapper;
import com.study.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserInformation(Integer uid) {
        //
        User user = userMapper.selectById(uid);
        //
        return user;
    }
}
