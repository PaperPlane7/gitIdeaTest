package com.zym.service;

import com.zym.pojo.Conference_request;

import java.util.List;


public interface Conference_requestService {
    int addRequest(int conId,boolean cName, boolean cSex, boolean cIdNum, boolean cTel, boolean cCompany, boolean cRoom);

    //查询约束
    Conference_request queryRequest(int conId);

    //查询所有约束
    List<Conference_request> queryAllRequest();

    //删除约束
    int deleteConRe( int conId);
}
