package com.zym.dao;

import com.zym.pojo.User;
import com.zym.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一：执行SQL
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SQlSession
        sqlSession.close();
    }
}
