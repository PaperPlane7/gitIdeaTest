<%@ page import="com.zym.pojo.Conference" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/12/1
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet"  href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>

<%Conference conference = (Conference) request.getAttribute("conference");%>

<div  class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">会议信息，ID号：<%out.print(conference.getConId());%></p></caption>
        <tr>
            <th>会议名称：</th>
            <td><%out.print(conference.getConName());%></td>
        </tr>
        <tr>
            <th>发布者Id：</th>
            <td><%out.print(conference.getUserId());%></td>
        </tr>
        <tr>
            <th>会议描述：</th>
            <td><%out.print(conference.getConDescription());%></td>
        </tr>
        <tr>
            <th>发布时间：</th>
            <td><%out.print(conference.getConCreateTime());%></td>
        </tr>
        <tr>
            <th>截止时间：</th>
            <td><%out.print(conference.getConEndTime());%></td>
        </tr>
        <tr>
            <th>开会时间：</th>
            <td><%out.print(conference.getConTime());%></td>
        </tr>
        <tr>
            <th>开会地点：</th>
            <td><%out.print(conference.getConLocation());%></td>
        </tr>
        <tr>
            <th>会议嘉宾：</th>
            <td><%out.print(conference.getConGuest());%></td>
        </tr>
        <tr>
            <th>预备酒店：</th>
            <td><%out.print(conference.getConHotel());%></td>
        </tr>
    </table>
</div>



</body>
</html>
