package com.zym.service;

import com.zym.dao.UserMapper;
import com.zym.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(String userId, String userPwd) {
        return userMapper.addUser(userId,userPwd);
    }

    public int updateUserPwd(String userId, String userPwd) {
        return userMapper.updateUserPwd(userId,userPwd);
    }

    @Override
    public int updateUserLevelUP(String userId) {
        return userMapper.updateUserLevelUP(userId);
    }

    @Override
    public int updateUserLevelDown(String userId) {
        return userMapper.updateUserLevelDown(userId);
    }

    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    public User queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public int queryUserLevel(String userId) {
        return userMapper.queryUserLevel(userId);
    }

    @Override
    public int deleteUserInCon(String userId) {
        return userMapper.deleteUserInCon(userId);
    }
}
