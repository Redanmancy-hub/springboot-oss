package com.springboot.springbootmybatis.service;

import com.github.pagehelper.PageInfo;
import com.springboot.springbootmybatis.pojo.vo.UserResponseVO;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    PageInfo<UserResponseVO> getUserPage(int page, int size);
}
