package com.zym.service;

import com.zym.dao.Conference_requestMapper;
import com.zym.pojo.Conference;
import com.zym.pojo.Conference_request;

import java.sql.Timestamp;
import java.util.List;

public class Conference_requestServiceImpl implements Conference_requestService {

    private Conference_requestMapper conference_requestMapper;

    public void setConference_requestMapper(Conference_requestMapper conference_requestMapper) {
        this.conference_requestMapper = conference_requestMapper;
    }

    @Override
    public int addRequest(int conId, boolean cName, boolean cSex, boolean cIdNum, boolean cTel, boolean cCompany, boolean cRoom) {
        return conference_requestMapper.addRequest(conId, cName, cSex, cIdNum, cTel, cCompany, cRoom);
    }

    @Override
    public Conference_request queryRequest(int conId) {
        return conference_requestMapper.queryRequest(conId);
    }

    @Override
    public List<Conference_request> queryAllRequest() {
        return conference_requestMapper.queryAllRequest();
    }

    @Override
    public int deleteConRe(int conId) {
        return conference_requestMapper.deleteConRe(conId);
    }
}
