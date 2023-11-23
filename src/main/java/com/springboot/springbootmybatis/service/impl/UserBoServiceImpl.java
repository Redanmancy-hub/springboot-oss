package com.springboot.springbootmybatis.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.springboot.springbootmybatis.mapper.UserBoMapper;
import com.springboot.springbootmybatis.pojo.bo.UserBo;
import com.springboot.springbootmybatis.service.UserBoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserBoServiceImpl implements UserBoService {

    @Resource
    private UserBoMapper userBoMapper;

    /**
     * 查询用户列表
     * @return
     */
    @Override
    public List<UserBo> getList() {
        return userBoMapper.selectList();
    }

    /**
     * 修改用户
     * @param userBo
     * @return
     */
    @Override
    public UserBo update(UserBo userBo) {
        return null;
    }

    /**
     * 根据id去查询用户
     * @param id
     * @return
     */
    @Override
    public UserBo getById(Long id) {
        return userBoMapper.selectById(id);
    }
}
