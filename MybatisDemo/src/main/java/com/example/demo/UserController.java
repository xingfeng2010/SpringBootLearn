package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 新增记录
     * */
    @RequestMapping(value = "/save")
    public List<User> saveUser(String name,Integer age,String address){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        return  userService.save(user);
    }
    //查询
    @RequestMapping(value = "/findbyid")
    public User findUserById(Integer id){
        return userService.selectUserById(id);
    }
    @RequestMapping(value = "findall")
    public List<User> findAll(){
        return userService.findAll();
    }
    //更新
    @RequestMapping(value = "/update")
    public User updateUser(Integer id,String name,Integer age,String address){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        return userService.update(user);
    }
    //删除
    @RequestMapping(value = "/delete")
    public List<User> deleteUser(Integer id){
        return userService.delete(id);
    }

}
