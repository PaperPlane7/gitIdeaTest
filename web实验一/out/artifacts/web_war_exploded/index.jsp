<%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/10/12
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP测试</title>
  </head>
  <body>
    <script type="text/javascript">
      function fun() {
        document.title = "新的标题";
        window.alert(document.location)
      }
    </script>
    <input type="button" onclick="fun()" value="按钮">
  </body>
</html>
