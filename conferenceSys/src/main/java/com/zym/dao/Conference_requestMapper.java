package com.zym.dao;

import com.zym.pojo.Conference_request;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Conference_requestMapper {
    //创建约束
    int addRequest(@Param("conId") int conId,@Param("cName") boolean cName,@Param("cSex") boolean cSex,@Param("cIdNum") boolean cIdNum,@Param("cTel") boolean cTel,@Param("cCompany") boolean cCompany,@Param("cRoom") boolean cRoom);

    //查询约束
    Conference_request queryRequest(@Param("conId") int conId);

    //查询所有约束
    List<Conference_request> queryAllRequest();

    //删除约束
    int deleteConRe(@Param("conId") int conId);
}
