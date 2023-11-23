package com.springboot.springbootmybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springbootmybatis.mapper.UserMapper;
import com.springboot.springbootmybatis.pojo.User;
import com.springboot.springbootmybatis.pojo.vo.UserResponseVO;
import com.springboot.springbootmybatis.service.UserService;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.pagehelper.page.PageMethod.startPage;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public PageInfo<UserResponseVO> getUserPage(int page, int size) {
        // 开启分页
        startPage(page,size);
        List<User> userPage = userMapper.getUserPage();
        //使用流式操作对数据列表进行转换为UserResponseVO和封装
        List<UserResponseVO> collect = userPage.stream().map(e -> {
            UserResponseVO userResponseVO = new UserResponseVO();
            BeanUtils.copyProperties(e, userResponseVO);    //使用BeanUtils.copyProperties()方法将属性拷贝到新的对象中
            return userResponseVO;
        }).collect(Collectors.toList());    //使用collect(Collectors.toList())将转换后的对象收集到一个新的列表collect中。
        // 通过new PageInfo<>(collect)创建一个包含分页信息的PageInfo<NewsResponseVO>对象，并将其返回
        PageInfo<UserResponseVO> result = new PageInfo<>(collect);
        return result;
    }
}
