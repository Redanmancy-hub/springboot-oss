package com.springboot.springbootmybatis.controller;

import com.springboot.springbootmybatis.pojo.UserLogin;
import com.springboot.springbootmybatis.pojo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("ajax")
public class ajaxloginController {

    @RequestMapping
    public String info(){
        return "ajaxlogin";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login( UserLogin user) {
        System.out.println(user.getUsername()+"   "+   user.getPassword());
        return "登录成功";
    }

    @RequestMapping("loginjson")
    @ResponseBody
    public ResultData loginjson(@RequestBody UserLogin user, HttpSession httpSession) {
        System.out.println(user.getUsername()+"   "+   user.getPassword());
        // 从session中取出用户注册的数据
        UserVo userinfo = (UserVo) httpSession.getAttribute("userinfo");
        if (userinfo != null &&
                userinfo.getUsername().equals(user.getUsername()) &&
        userinfo.getPassword().equals(user.getPassword())) {
            // 将登录的数据存入session
            httpSession.setAttribute("userLogin", user);
            ResultData rd = new ResultData();
            rd.setCode(0);
            rd.setMsg("登录成功");
            return rd;
        }else {
            ResultData rd = new ResultData();
            rd.setCode(1);
            rd.setMsg("用户名或密码错误");
            return rd;
        }
    }

    @RequestMapping("tohome")
    public String tohome() {
        return "home";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/remove")
    public String remove(SessionStatus sessionStatus,HttpSession httpSession){
        httpSession.removeAttribute("userLogin");
        sessionStatus.setComplete();
        return "ajaxlogin";
    }
}

