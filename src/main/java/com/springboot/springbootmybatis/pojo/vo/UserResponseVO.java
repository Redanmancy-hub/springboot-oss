package com.springboot.springbootmybatis.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户 responseVO")

public class UserResponseVO {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
