package com.zym.service;

import com.zym.dao.ParticipateMapper;
import com.zym.pojo.Conference;
import com.zym.pojo.Participate;

import java.util.List;

public class ParticipateServiceImpl implements ParticipateService {

    private ParticipateMapper participateMapper;

    public void setParticipateMapper(ParticipateMapper participateMapper) {
        this.participateMapper = participateMapper;
    }

    @Override
    public int addParticipate(int conId, String userId) {
        return participateMapper.addParticipate(conId, userId);
    }

    @Override
    public List<Participate> queryParticipateInCon(int conId) {
        return participateMapper.queryParticipateInCon(conId);
    }

    @Override
    public List<Conference> queryParticipate(String userId) {
        return participateMapper.queryParticipate(userId);
    }

    @Override
    public int updateName(int conId, String userId, String Name) {
        return participateMapper.updateName(conId, userId, Name);
    }

    @Override
    public int updateSex(int conId, String userId, String Sex) {
        return participateMapper.updateSex(conId, userId, Sex);
    }

    @Override
    public int updateIdNum(int conId, String userId, String IdNum) {
        return participateMapper.updateIdNum(conId, userId, IdNum);
    }

    @Override
    public int updateTel(int conId, String userId, String Tel) {
        return participateMapper.updateTel(conId, userId, Tel);
    }

    @Override
    public int updateCompany(int conId, String userId, String Company) {
        return participateMapper.updateCompany(conId,userId, Company);
    }

    @Override
    public int updateRoom(int conId, String userId, boolean Room) {
        return participateMapper.updateRoom(conId,userId, Room);
    }

    @Override
    public int deleteParticipate(int conId, String userId) {
        return participateMapper.deleteParticipate(conId,userId);
    }

    @Override
    public int deleteParticipateInCon(int conId) {
        return participateMapper.deleteParticipateInCon(conId);
    }
}
