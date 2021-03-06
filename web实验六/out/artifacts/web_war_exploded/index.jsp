<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/11/4
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="css/bootstrap.min.css" rel="stylesheet"/>
  <link href="css/style.css" rel="stylesheet"/>
  <title>网上书店</title>
</head>

<body onload="initAJAX()">
<div class="header">
  <div class="container">
    <div class="row">
      <div class="login span4">
        <h1><a href=""> 欢迎来到<strong>我的</strong>书店</a>
          <span class="red">.</span></h1>
      </div>
      <div class="links span8">
        <a class="login" href="login.html" rel="tooltip" data-placement="bottom" data-toggle="modal" data-target="#myModal"></a>
        <div class="modal fade" id="myModal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header"></div>
              <div class="modal-body"></div>
              <div class="modal-footer"></div>
            </div>
          </div>
        </div>

        <a class="register" href="" rel="tooltip" data_placement="bottom"></a>
      </div>
    </div>
  </div>
</div> <%--header--%>

<div class="row"> <%--下方左右div控制--%>
  <div class="col-md-3"> <%--左侧菜单div控制--%>
    <ul class="nav nav-list">
      <li class="nav-header">书籍类型</li>
      <%
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=bookstore";
        String sql = "select id,name from category ";
        Connection conn = DriverManager.getConnection(url,"sa","sherlock1999");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next())
        {
      %>
      <li>
        <a href='javascript:showBook("<%=rs.getString("id")%>")'><%=rs.getString("name")%></a>
      </li>
      <%
        }
        stat.close();
        conn.close();
      %>
    </ul>
  </div><%--左侧菜单div控制--%>

  <div class="col-md-9" id="book"><%-- 书籍局部控制 --%>
    <script language="JavaScript">
      function showBook(categoryID) {
        xmlHttp.onreadystatechange = function() {
          if (xmlHttp.readyState == 4) {
            if(xmlHttp.status == 200) {
              var data = xmlHttp.responseText;
              document.getElementById("book").innerHTML = data;
            }
          }
        }
        xmlHttp.open("GET", "getBook.jsp?id="+categoryID, true);
        xmlHttp.send();
      }
    </script>
  </div><%-- 书籍局部控制 --%>
</div><%--下方左右div控制--%>

  <script src="js/jquery.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/commons.js"></script>
  </body>
</html>
