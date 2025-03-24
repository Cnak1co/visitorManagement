package com.study.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.web.entity.User;

public interface UserService extends IService<User> {

    User queryUserInformation(Integer uid);
}
