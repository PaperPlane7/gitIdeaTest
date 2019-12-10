package com.zym.dao;

import com.zym.pojo.Conference;
import com.zym.pojo.Participate;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ParticipateMapper {
    //添加参加者
    int addParticipate(@Param("conId") int conId,@Param("userId") String userId);

    //查询会议中的参加者
    List<Participate> queryParticipateInCon(@RequestParam("conId") int conId);

    //查询参加者
    List<Conference> queryParticipate(@Param("userId") String userId);

    //添加姓名
    int updateName(@Param("conId") int conId,@Param("userId") String userId,@Param("Name") String Name);

    //添加性别
    int updateSex(@Param("conId") int conId,@Param("userId") String userId,@Param("Sex") String Sex);

    //添加身份证
    int updateIdNum(@Param("conId") int conId,@Param("userId") String userId,@Param("IdNum") String IdNum);

    //添加电话
    int updateTel(@Param("conId") int conId,@Param("userId") String userId,@Param("Tel") String Tel);

    //添加公司
    int updateCompany(@Param("conId") int conId,@Param("userId") String userId,@Param("Company") String Company);

    //添加需要房间
    int updateRoom(@Param("conId") int conId,@Param("userId") String userId, @Param("Room") boolean Room);

    //删除参加者
    int deleteParticipate(@Param("conId") int conId,@Param("userId") String userId);

    //删除会议所有参加者
    int deleteParticipateInCon(@Param("conId") int conId);

}
