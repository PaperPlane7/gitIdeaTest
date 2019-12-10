package com.zym.service;

import com.zym.pojo.Conference;
import com.zym.pojo.Participate;

import java.util.List;

public interface ParticipateService {
    //添加参加者
    int addParticipate(int conId, String userId);

    //查询会议中的参加者
    List<Participate> queryParticipateInCon(int conId);

    //查询参加者
    List<Conference> queryParticipate(String userId);

    //添加姓名
    int updateName(int conId,String userId,String Name);

    //添加性别
    int updateSex(int conId,String userId,String Sex);

    //添加身份证
    int updateIdNum(int conId,String userId,String IdNum);

    //添加电话
    int updateTel(int conId, String userId, String Tel);

    //添加公司
    int updateCompany(int conId, String userId, String Company);

    //添加需要房间
    int updateRoom(int conId, String userId,  boolean Room);

    //删除参加者
    int deleteParticipate( int conId, String userId);

    //删除会议中参加者
    int deleteParticipateInCon(int conId);
}
