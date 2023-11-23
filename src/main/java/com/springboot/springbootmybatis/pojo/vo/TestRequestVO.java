package com.springboot.springbootmybatis.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.context.annotation.Bean;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("这是一个测试类")
public class TestRequestVO {
    @ApiModelProperty("姓名")
    private String name;
}
