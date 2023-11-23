package com.springboot.springbootmybatis.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String birthday;
}
