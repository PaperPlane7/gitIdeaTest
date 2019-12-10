package com.zym.service;

import com.zym.dao.ConferenceMapper;
import com.zym.pojo.Conference;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ConferenceServiceImpl implements ConferenceService{
    private ConferenceMapper conferenceMapper;

    public void setConferenceMapper(ConferenceMapper conferenceMapper) {
        this.conferenceMapper = conferenceMapper;
    }

    @Override
    public int addConference(int conId,String conName, String userId, String conDescription, Date conCreateTime, Date conEndTime, Date conTime, String conLocation, String conGuest, String conHotel) {
        return conferenceMapper.addConference(conId,conName, userId, conDescription, conCreateTime, conEndTime, conTime, conLocation, conGuest, conHotel);
    }

    @Override
    public int deleteConference(int conId) {
        return conferenceMapper.deleteConference(conId);
    }

    @Override
    public List<Conference> queryAllConferenceJoinable(String userId) {
        return conferenceMapper.queryAllConferenceJoinable(userId);
    }

    @Override
    public int queryConIdByTime(String userId, Date conCreateTime) {
        return conferenceMapper.queryConIdByTime(userId, conCreateTime);
    }

    @Override
    public Conference queryConferenceById(int conId) {
        return conferenceMapper.queryConferenceById(conId);
    }

    @Override
    public List<Conference> queryConferenceByUserId(String userId) {
        return conferenceMapper.queryConferenceByUserId(userId);
    }

    @Override
    public List<Conference> queryAllConference() {
        return conferenceMapper.queryAllConference();
    }

    @Override
    public int queryAllConferenceNum() {
        return conferenceMapper.queryAllConferenceNum();
    }

    @Override
    public int getConferenceNum() {
        return conferenceMapper.getConferenceNum();
    }
}
