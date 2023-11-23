package com.springboot.springbootmybatis.controller;


import com.springboot.springbootmybatis.pojo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    //使用ModelAndView对象
    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }


    //使用简单数据类型接收视图参数
    //使用Model对象
    @PostMapping("registerInfo")
    public String registerInfo(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("age") int age,
                               @RequestParam("sex") String sex,
                               @RequestParam("birthday") String birthday,
                               Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        model.addAttribute("birthday", birthday);
        return "register_info";
    }

    //实体类对象参数
    //使用ModelAndView对象
    @PostMapping("registerAll")
    public ModelAndView registerAll(UserVo userVo, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(userVo);
        modelAndView.setViewName("register_all");
        // 将用户注册的数据存入session
        httpSession.setAttribute("userinfo",userVo);
        return modelAndView;
    }
}
