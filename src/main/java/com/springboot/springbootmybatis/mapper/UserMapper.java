package com.springboot.springbootmybatis.mapper;

import com.springboot.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper{

    List<User> getUserPage();
}
