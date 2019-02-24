package com.example.demo;

import java.util.List;

public interface UserService {
    //新增
    public List<User> save(User user);
    //更新
    public User update(User user);
    //查询
    public User selectUserById(Integer id);
    public List<User> findAll();
    //删除
    public List<User> delete(Integer id);
}
