package com.zsq.mp.service.impl;

import com.zsq.mp.entity.User;
import com.zsq.mp.mapper.UserMapper;
import com.zsq.mp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return null;
    }
}
