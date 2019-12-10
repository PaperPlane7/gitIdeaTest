package com.zym.dao;

import com.zym.pojo.Conference;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ConferenceMapper {
    //创建会议
    int addConference(@Param("conId") int conId,@Param("conName") String conName, @Param("userId") String userId, @Param("conDescription") String conDescription, @Param("conCreateTime") Date conCreateTime, @Param("conEndTime") Date conEndTime, @Param("conTime") Date conTime, @Param("conLocation") String conLocation, @Param("conGuest") String conGuest, @Param("conHotel") String conHotel);

    //删除会议
    int deleteConference(@Param("conId")int conId);

    //修改会议


    //查询会议
    List<Conference>queryAllConferenceJoinable(@Param("userId")String userId);

    int queryConIdByTime(@Param("userId") String userId,@Param("conCreateTime") Date conCreateTime);

    Conference queryConferenceById(@Param("conId") int conId);

    List<Conference>queryConferenceByUserId(@Param("userId")String userId);

    List<Conference>queryAllConference();

    int queryAllConferenceNum();

    int getConferenceNum();


}
