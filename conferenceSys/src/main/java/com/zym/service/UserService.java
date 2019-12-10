package com.zym.service;

import com.zym.pojo.User;

import java.util.List;

public interface UserService {
    //创建用户
    int addUser( String userId,String userPwd);

    //修改用户密码
    int updateUserPwd(String userId,String userPwd);


    //提升用户等级
    int updateUserLevelUP(String userId);

    //降低用户等级
    int updateUserLevelDown(String userId);

    //删除用户
    int deleteUserById(String userId);

    //根据Id查询用户
    User queryUserById(String userId);

    //查询全部用户
    List<User> queryAllUser();

    //查询用户等级
    int queryUserLevel( String userId);

    //删除用户参加的所有会议
    int deleteUserInCon( String userId);

}
