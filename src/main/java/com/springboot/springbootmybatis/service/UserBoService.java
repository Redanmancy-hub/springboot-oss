package com.springboot.springbootmybatis.service;


import com.springboot.springbootmybatis.pojo.bo.UserBo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserBoService {
    List<UserBo> getList();

    UserBo update(UserBo userBo);

    UserBo getById(Long id);
}
