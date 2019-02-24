package com.example.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //新增
    @Insert("insert into user (name,age,address) values (#{name},#{age},#{address})")
    public int save(User user);
    //更新
    @Update("update user set name = #{name},age = #{age},address = #{address} where id = #{id}")
    public void update(User user);
    //根据ID查询
    @Select("select * from user where id = #{id}")
    public User selectUserById(@Param("id") Integer id);
    //查询全部记录
    @Select("select * from user")
    public List<User> findAll();
    //删除记录-删除后返回列表
    @Delete("delete from user where id = #{id}")
    public void delete(@Param("id") Integer id);
}
