package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> save(User user) {
        //新增一条记录
        userMapper.save(user);
        //返回全部记录的列表
        return userMapper.findAll();
    }

    @Override
    public User update(User user) {
        //更新记录
        userMapper.update(user);
        return userMapper.selectUserById(user.getId());
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> delete(Integer id) {
        userMapper.delete(id);
        return userMapper.findAll();
    }
}
