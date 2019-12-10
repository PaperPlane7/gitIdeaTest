<%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/11/30
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建会议</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet"  href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="center-block">
    <%

        int conferenceNum= (int) request.getAttribute("conferenceNum")+1;
        String userId = (String) request.getAttribute("userId");
        int conId =conferenceNum;
    %>
<form action="${pageContext.request.contextPath}/conference/create" method="post">
    <div class="form-group">

        <label for="conId">会议唯一id：</label>
        <input  name="conId" id="conId" class="form-control" type="text" required="required" value="<%out.print(conId);%>" readonly><br>

        <label for="conName">请输入会议名称：</label>
        <input name="conName" id="conName" class="form-control" type="text" required="required"><br>

        <label for="userId">发布者Id：</label>
        <input name="userId" id="userId" class="form-control" type="text" value="<%out.print(userId);%>" readonly required="required"><br>

        <label for="conDescription">请输入会议描述：</label>
        <input name="conDescription" id="conDescription" class="form-control" type="text" required="required"><br>

        <label for="conEndTime">请输入会议参加的截止时间：</label>
        <input name="conEndTime" id="conEndTime" class="form-control" type="date" required="required"><br>

        <label for="conTime">请输入会议开始时间：</label>
        <input name="conTime" id="conTime" class="form-control" type="date" required="required"><br>

        <label for="conLocation">请输入会议举行的地点：</label>
        <input name="conLocation" id="conLocation" class="form-control" type="text" required="required"><br>

        <label for="conGuest">请输入会议来宾：</label>
        <input name="conGuest" id="conGuest" class="form-control" type="text" required="required"><br>

        <label for="conHotel">请输入会议酒店：</label>
        <input name="conHotel" id="conHotel" class="form-control" type="text" required="required"><br>
    </div>


<%--    请选择参加者需要填写的信息--%>

    <input name="userinform" type="checkbox" value="hide" style="display:none" checked="checked">
    <input name="userinform" type="checkbox" value="cName">姓名
    <input name="userinform" type="checkbox" value="cSex">性别
    <input name="userinform" type="checkbox" value="cIdNum">身份证号
    <input name="userinform" type="checkbox" value="cTel">电话
    <input name="userinform" type="checkbox" value="cCompany">工作单位
    <input name="userinform" type="checkbox" value="cRoom">住房安排
    <input class="btn btn-default" type="submit" value="提交">

</form>
</div>
</body>
</html>
