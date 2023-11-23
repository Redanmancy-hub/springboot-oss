package com.springboot.springbootmybatis.controller;


import com.springboot.springbootmybatis.pojo.bo.UserBo;
import com.springboot.springbootmybatis.service.UserBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/userBo")
public class UserBoController {

    @Autowired
    private UserBoService userBoService;

    /**
     * 查询用户列表
     */
    @GetMapping("/list")
    @Transactional
    public ModelAndView userBoList(ModelAndView modelAndView){
        List<UserBo> userBoList = userBoService.getList();
        modelAndView.addObject(userBoList);
        System.out.println(userBoList);
        modelAndView.setViewName("userManagement");
        return modelAndView;
    }

    /**
     * 根据用户id去查询用户
     */
    @GetMapping("/{id}")
    public UserBo userBoById(@PathVariable Long id){
        return userBoService.getById(id);
    }

    /**
     * 修改用户
     */
    @PostMapping("update")
    public ModelAndView userUpdate(@RequestBody UserBo userBo, ModelAndView modelAndView){
        UserBo updatedUser = userBoService.update(userBo);
        modelAndView.addObject("user", updatedUser);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
