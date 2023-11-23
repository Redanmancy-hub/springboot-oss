package com.springboot.springbootmybatis.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {
    private Integer id;
    private String username;
    private Integer role;
    private Integer sex;
    private Integer age;
}
