package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jdbc")
public class JdbcController {
    @Autowired
    private JdbcService jdbcService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List list() {
        return jdbcService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(String name, String age, String address) {
        int count = jdbcService.save(name, age, address);
        if (count > 0) {
            return "save success";
        } else {
            return "save failed";
        }
    }

    /**
     *更新记录名称字段，成功返回update name success，失败返回update name failed
     * */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(String id,String name){
        int count = jdbcService.update(id,name);
        if (count>0){
            return "update name success";
        }else{
            return "update name failed";
        }
    }
    /**
     *删除，返回剩余所有记录
     * */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List delete(String id) {
        jdbcService.delete(id);
        return jdbcService.findAll();
    }
}
