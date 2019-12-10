<%@ page import="java.util.List" %>
<%@ page import="com.zym.pojo.Conference_request" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/12/1
  Time: 13:02
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
</head>
<body>
<%
    Conference_request conference_requests = (Conference_request) request.getAttribute("conference_request");
%>
<div class="center-block" style="width: 60%">
    <form action="${pageContext.request.contextPath}/conference/fillInformation" method="post">
        <div class="form-group">

            <input name="conId" value="<%out.print(request.getAttribute("conId"));%>" style="display:none">
            <label for="userId">用户Id：</label>
            <input name="userId" id="userId" class="form-control" value="<%out.print(request.getAttribute("userId"));%>" readonly><br>
            <%
                if (conference_requests.isCName()){
                    out.println("<label for=\"Name\">请输入姓名：</label>\n" +
                            "            <input name=\"Name\" id=\"Name\" class=\"form-control\" type=\"text\" required=\"required\"><br>");
                }
                if (conference_requests.isCSex()){
                    out.println("<label for=\"Sex\">选择性别：</label>\n" +
                            "            <select name=\"Sex\" id=\"Sex\" class=\"form-control\" required=\"required\">\n" +
                            "                <option value=\"男\">男</option>\n" +
                            "                <option value=\"女\">女</option>\n" +
                            "            </select><br>");
                }
                if (conference_requests.isCIdNum()){
                    out.println("<label for=\"IdNum\">输入身份证：</label>\n" +
                            "            <input name=\"IdNum\" id=\"IdNum\" class=\"form-control\" required=\"required\" type=\"text\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\"><br>\n");
                }
                if (conference_requests.isCTel()){
                    out.println("<label for=\"Tel\">输入电话号码：</label>\n" +
                            "            <input name=\"Tel\" id=\"Tel\" class=\"form-control\" required=\"required\" type=\"text\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\"><br>\n");
                }
                if (conference_requests.isCCompany()){
                    out.println("<label for=\"Company\">输入工作单位：</label>\n" +
                            "            <input name=\"Company\" id=\"Company\" class=\"form-control\" type=\"text\" required=\"required\"><br>");
                }
                if (conference_requests.isCRoom()){
                    out.println("<label for=\"roomBool\">是否需要床位：</label>\n" +
                            "            <select name=\"roomBool\" id=\"roomBool\" class=\"form-control\" required=\"required\">\n" +
                            "                <option value=\"需要\">需要</option>\n" +
                            "                <option value=\"不需要\">不需要</option>\n" +
                            "            </select><br>");
                }else {
                    out.println("<input name=\"roomBool\" type=\"text\" value=\"不需要\" style=\"display:none\">");
                }
            %>
            <input type="submit" value="提交">

<%--            <label for="Name">请输入姓名：</label>--%>
<%--            <input name="Name" id="Name" class="form-control" type="text" required="required"><br>--%>

<%--            <label for="Sex">选择性别：</label>--%>
<%--            <select name="Sex" id="Sex" class="form-control" required="required">--%>
<%--                <option value="男">男</option>--%>
<%--                <option value="女">女</option>--%>
<%--            </select><br>--%>

<%--            <label for="IdNum">输入身份证：</label>--%>
<%--            <input name="IdNum" id="IdNum" class="form-control" required="required" type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br>--%>

<%--            <label for="Tel">输入电话号码：</label>--%>
<%--            <input name="Tel" id="Tel" class="form-control" required="required" type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br>--%>

<%--            <label for="Company">输入工作单位：</label>--%>
<%--            <input name="Company" id="Company" class="form-control" type="text" required="required"><br>--%>

<%--            <label for="roomBool">是否需要床位：</label>--%>
<%--            <select name="roomBool" id="roomBool" class="form-control" required="required">--%>
<%--                <option value="需要">需要</option>--%>
<%--                <option value="不需要">不需要</option>--%>
<%--            </select><br>--%>
<%--            <input type="text" value="不需要" style="display:none">--%>
        </div>
    </form>
</div>


>





</body>
</html>
