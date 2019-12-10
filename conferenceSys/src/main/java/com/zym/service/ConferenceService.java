package com.zym.service;

import com.zym.pojo.Conference;

import java.sql.Date;
import java.util.List;

public interface ConferenceService {
    //创建会议
    int addConference(int conId,String conName, String userId, String conDescription, Date conCreateTime, Date conEndTime, Date conTime, String conLocation, String conGuest, String conHotel);

    //删除会议
    int deleteConference(int conId);

    //修改会议

    //查询会议
    List<Conference>queryAllConferenceJoinable(String userId);

    int queryConIdByTime(String userId,Date conCreateTime);

    Conference queryConferenceById(int conId);

    List<Conference> queryConferenceByUserId(String userId);

    List<Conference>queryAllConference();

    int queryAllConferenceNum();

    int getConferenceNum();
}
