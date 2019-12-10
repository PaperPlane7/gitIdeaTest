<%@ page import="com.zym.pojo.Conference" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zym.pojo.Conference_request" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/11/30
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet"  href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/qrcode.min.js"></script>
</head>
<body>
<h1>会议大厅</h1>
<hr style="filter: alpha(opacity=100,finishopacity=0,style=1)" width="80%" color='#987cb9' size=3>
<div class="center-block">
    <table class="table table-hover">
        <caption><p class="bg-primary" style="height: 40px ;width: auto">可以参加的会议</p></caption>

        <tr>
            <th>会议Id：</th>
            <th>会议名称：</th>
            <th>会议地点：</th>
            <th>会议时间：</th>
            <th>#</th>
        </tr>
        <%
            List<Conference> joinable= (List<Conference>) request.getAttribute("joinable");
            for (Conference conference : joinable) {
                out.println("<tr>");
                out.println("<td>"+"<a href="+"/conferenceSys_war_exploded"+"/conference/conferenceIn?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">"+conference.getConId()+"</a></td>");
                out.println("<td>"+conference.getConName()+"</td>");
                out.println("<td>"+conference.getConLocation()+"</td>");
                out.println("<td>"+conference.getConTime()+"</td>");
                out.println("<td>"+"<a href="+"/conferenceSys_war_exploded"+"/conference/join?conId="+conference.getConId()+"&userId="+request.getAttribute("userId")+">参加</a></td>");
                out.println("</tr>");
            }
        %>
    </table>

</div>


<%List<Conference_request> conference_requests = (List<Conference_request>) request.getAttribute("conference_requests");%>




</body>
</html>
