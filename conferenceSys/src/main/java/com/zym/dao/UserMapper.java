package com.zym.dao;

import com.zym.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //创建用户
    int addUser(@Param("userId") String userId,@Param("userPwd") String userPwd);

    //修改用户密码
    int updateUserPwd(@Param("userId") String userId,@Param("userPwd") String userPwd);


    //提升用户等级
    int updateUserLevelUP(@Param("userId") String userId);

    //降低用户等级
    int updateUserLevelDown(@Param("userId") String userId);

    //删除用户
    int deleteUserById(@Param("userId") String userId);

    //根据Id查询用户
    User queryUserById(@Param("userId") String userId);

    //查询全部用户
    List<User> queryAllUser();

    //查询用户等级
    int queryUserLevel(@Param("userId") String userId);

    //删除用户参加的所有会议
    int deleteUserInCon(@Param("userId") String userId);

}
