package com.springboot.springbootmybatis.pojo;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}
