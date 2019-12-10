<%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/11/4
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getParameter("username")==""){
        out.print("判断为空");
    }
    out.print("欢迎"+request.getParameter("username")+"登陆成功");
%>
</body>
</html>