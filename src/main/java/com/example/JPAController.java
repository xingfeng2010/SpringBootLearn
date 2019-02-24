package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class JPAController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 数据新增或更新，save方法可以执行添加也可以执行更新，如果需要执行持久化的实体存在主键值则更新数据，如果不存在则添加数据。
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(User user) {
        System.out.print("hellow");
        return userJPA.save(user);
    }

    /**
     * 查询用户信息
     * */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(){
        return userJPA.findAll();
    }


    /**
     * 删除用户信息，删除信息后返回剩余信息
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<User> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
