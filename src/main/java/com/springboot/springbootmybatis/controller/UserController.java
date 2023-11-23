package com.springboot.springbootmybatis.controller;


import com.github.pagehelper.PageInfo;
import com.springboot.springbootmybatis.pojo.vo.TestRequestVO;
import com.springboot.springbootmybatis.pojo.vo.UserResponseVO;
import com.springboot.springbootmybatis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
@Api(tags="用户管理")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping ("/getPage/{pageNum}/{pageSize}")
    @ApiOperation(value = "获取用户数据分页")
    public PageInfo<UserResponseVO> getUserPage(@PathVariable("pageNum") int pageNum,
                                                @PathVariable("pageSize")int pageSize){
        return userService.getUserPage(pageNum,pageSize);
    }

    @GetMapping("/get")
    @ApiOperation(value = "获取分页")
    public PageInfo<UserResponseVO> getNewsPage(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "2")int pageSize){
        return userService.getUserPage(pageNum,pageSize);
    }

    @GetMapping("/test")
    @ApiOperation(value = "这是一个测试接口")
    public UserResponseVO test(TestRequestVO testRequestVO){
        UserResponseVO userResponseVO = new UserResponseVO();
        userResponseVO.setUsername(testRequestVO.getName());
        return userResponseVO;
    }
}
