<%@ page import="java.util.List" %>
<%@ page import="com.zym.pojo.Conference" %>
<%@ page import="com.zym.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/11/28
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>个人主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet"  href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>

    <script type="text/javascript" src="../js/qrcode.min.js"></script>
</head>
<body>


<script type="text/javascript">
    if (${error.equals("createfail")}){
        alert("创建会议失败，换个ID再试试吧！");
    }
    if (${error.equals("createrequestfail")}){
        alert("创建需求失败！");
    }
</script>


<div>
<h1>个人主页,欢迎您<%out.print(((User)request.getAttribute("msg")).getUserId());%></h1>
</div>
<div style="float: right">
<h3><a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/jsp/login.jsp">返回登陆页面</a></h3>
</div>

${con}

<%
    int userLevel = (int) request.getAttribute("userLevel");
%>
<div <%
if (userLevel<2)
    out.print("style=\"display: none\"");
%>>
<hr style="filter: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color='#987cb9' size=3>
<div>
    <h3>
    <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/conference/createByUser?userId=<%out.print(request.getAttribute("userId"));%>">创建会议</a>
    </h3>
</div>
<div class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">我创建的会议</p></caption>
        <tr>
            <th>会议Id：</th>
            <th>会议名称：</th>
            <th>会议地点：</th>
            <th>会议时间：</th>
            <th>会议截止时间</th>
            <th>#</th>
        </tr>
        <%
            List<Conference>conferencesCreate= (List<Conference>) request.getAttribute("conferencesCreate");
            for (Conference conference : conferencesCreate) {
                out.println("<tr>");
                out.println("<td>"+"<a href="+"/conferenceSys_war_exploded"+"/conference/conparticipate?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">"+conference.getConId()+"</a></td>");
                out.println("<td>"+conference.getConName()+"</td>");
                out.println("<td>"+conference.getConLocation()+"</td>");
                out.println("<td>"+conference.getConTime()+"</td>");
                out.println("<td>"+conference.getConEndTime()+"</td>");
                out.println("<td>"+"<a class=\"btn btn-danger\" href="+"/conferenceSys_war_exploded"+"/user/deleteCon?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">取消会议</a></td>");
                out.println("</tr>");
            }
        %>
    </table>
</div>
</div>


<hr style="filter: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color='#987cb9' size=3>
<div>
    <h3>
    <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/conference/hall?userId=<%out.print(request.getAttribute("userId"));%>">参加会议</a>

    </h3>
</div>
<div class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">我参加的会议</p></caption>
        <tr>
            <th>会议Id：</th>
            <th>会议名称：</th>
            <th>会议地点：</th>
            <th>会议时间：</th>
            <th>#</th>
        </tr>
        <%
            List<Conference>conferencesParticipate= (List<Conference>) request.getAttribute("conferencesParticipate");
            for (Conference conference : conferencesParticipate) {
                out.println("<tr>");
                out.println("<td>"+"<a href="+"/conferenceSys_war_exploded"+"/conference/conferenceIn?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">"+conference.getConId()+"</a></td>");
                out.println("<td>"+conference.getConName()+"</td>");
                out.println("<td>"+conference.getConLocation()+"</td>");
                out.println("<td>"+conference.getConTime()+"</td>");
                out.println("<td>"+"<a class=\"btn btn-danger\" href="+"/conferenceSys_war_exploded"+"/conference/deletebyuser?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">取消参加</a></td>");
                out.println("</tr>");
            }
        %>
    </table>
</div>


</body>
</html>
