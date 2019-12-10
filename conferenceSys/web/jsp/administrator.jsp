<%@ page import="com.zym.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zym.pojo.Conference" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/12/4
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet"  href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>

    <script type="text/javascript" src="../js/qrcode.min.js"></script>
</head>
<body>
<div style="float: right">
    <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/jsp/login.jsp">返回登陆页面</a>
</div>

<div class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">用户列表</p></caption>
        <tr>
            <th>用户Id：</th>
            <th>用户等级：</th>
            <th>操作</th>
            <th>操作</th>
            <th>操作</th>
        </tr>
        <%

            List<User>users= (List<User>) request.getAttribute("users");
            for (User user : users) {
                out.println("<tr>");
                out.println("<td>"+user.getUserId()+"</td>");
                out.println("<td>"+user.getUserLevel()+"</td>");
                out.println("<td>"+"<a class=\"btn btn-warning\" href="+"/conferenceSys_war_exploded"+"/admin/levelup?userId="+user.getUserId()+">增加用户等级</a></td>");
                out.println("<td>"+"<a class=\"btn btn-warning\" href="+"/conferenceSys_war_exploded"+"/admin/leveldown?userId="+user.getUserId()+">减少用户等级</a></td>");
                out.println("<td>"+"<a class=\"btn btn-danger\" href="+"/conferenceSys_war_exploded"+"/admin/deleteUser?userId="+user.getUserId()+">删除用户</a></td>");
                out.println("</tr>");
            }
        %>
    </table>
</div>
<div class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">会议列表</p></caption>
        <tr>
            <th>会议Id：</th>
            <th>发布者Id：</th>
            <th>会议名称：</th>
            <th>会议地点：</th>
            <th>会议时间：</th>
            <th>会议截止时间</th>
            <th>#</th>
        </tr>
        <%
            List<Conference> conferences = (List<Conference>) request.getAttribute("conferences");
            for (Conference conference : conferences) {
                out.println("<tr>");
                out.println("<td>"+"<a href="+"/conferenceSys_war_exploded"+"/conference/conparticipate?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">"+conference.getConId()+"</a></td>");
                out.println("<td>"+"发布者Id："+conference.getUserId()+"</td>");
                out.println("<td>"+"会议名称："+conference.getConName()+"</td>");
                out.println("<td>"+"会议地点："+conference.getConLocation()+"</td>");
                out.println("<td>"+"会议时间："+conference.getConTime()+"</td>");
                out.println("<td>"+"会议时间："+conference.getConEndTime()+"</td>");
                out.println("<td>"+"<a class=\"btn btn-danger\" href="+"/conferenceSys_war_exploded"+"/admin/deleteCon?conId="+conference.getConId()+">取消会议</a></td>");
                out.println("</tr>");
            }
        %>
    </table>
</div>
</body>
</html>
