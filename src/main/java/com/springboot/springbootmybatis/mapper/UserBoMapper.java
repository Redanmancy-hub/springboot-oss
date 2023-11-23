package com.springboot.springbootmybatis.mapper;


import com.springboot.springbootmybatis.pojo.bo.UserBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserBoMapper {
    List<UserBo> selectList();

    UserBo selectById(@Param("id") Long id);


/*    UserBo updateUserBo(@Param("id") Integer updateId);*/
}
