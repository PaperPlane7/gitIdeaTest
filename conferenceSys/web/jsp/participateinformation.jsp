<%@ page import="java.util.List" %>
<%@ page import="com.zym.pojo.Participate" %>
<%@ page import="com.zym.pojo.Conference_request" %>
<%@ page import="com.zym.pojo.Conference" %><%--
  Created by IntelliJ IDEA.
  User: winuser
  Date: 2019/12/1
  Time: 18:38
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
    <script src="../js/jquery.table2excel.js"></script>
    <script type="text/javascript" src="../js/qrcode.min.js"></script>
    <script language="JavaScript" type="text/javascript">

        function ExportToExcel() {
            $("#tableExcel").table2excel({
                exclude : ".noExl", //过滤位置的 css 类名
                filename : "表格导出", //文件名称
                name: "Excel Document Name.xlsx",
                exclude_img: false,//是否导出图片 false导出
                exclude_links: true,//是否导出链接 false导出
                exclude_inputs: true//是否导出输入框的值 true导出
            });
        }
    </script>
</head>
<body>

<%
    List<Participate> participates = (List<Participate>) request.getAttribute("participates");
    Conference_request conference_request = (Conference_request) request.getAttribute("conference_request");
%>

<table id="tableExcel" class="table table-hover">
    <caption><p class="bg-primary" style="height: 40px ;width: auto">创建的会议</p></caption>
    <%
        out.println("<tr>");
        out.println("<th>ID</th>");
        if (conference_request.isCName())
            out.println("<th>姓名</th>");
        if (conference_request.isCSex())
            out.println("<th>性别</th>");
        if (conference_request.isCIdNum())
            out.println("<th>身份证号码</th>");
        if (conference_request.isCTel())
            out.println("<th>电话</th>");
        if (conference_request.isCCompany())
            out.println("<th>工作单位</th>");
        if (conference_request.isCRoom())
            out.println("<th>房间需求</th>");
        out.println("</tr>");
        for (Participate participate : participates) {
            out.println("<tr>");
            out.println("<td>"+participate.getUserId()+"</td>");
            if (conference_request.isCName())
                out.println("<td>"+participate.getName()+"</td>");
            if (conference_request.isCSex())
                out.println("<td>"+participate.getSex()+"</td>");
            if (conference_request.isCIdNum())
                out.println("<td>"+participate.getIdNum()+"</td>");
            if (conference_request.isCTel())
                out.println("<td>"+participate.getTel()+"</td>");
            if (conference_request.isCCompany())
                out.println("<td>"+participate.getCompany()+"</td>");
            if (conference_request.isCRoom())
                out.println("<td>"+participate.isRoom()+"</td>");
            out.println("</tr>");
        }
    %>
</table>

<div >
    <button class="btn btn-default btn-lg" type="button" id="btnExport" onclick="ExportToExcel();">
        导出Excel
    </button>
    <button class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal" onclick="makeCode()">
        生成二维码
    </button>
</div>


<%
    Conference conference = (Conference) request.getAttribute("conference");
    String str = "conference:";
    str += "ConId:"+conference.getConId()+"||";
    str += "UserId:"+conference.getUserId()+"||";
    str += "Time:"+conference.getConTime();
%>

<%--------------------------------------------------------------------%>
<input id="text" type="text" name = "ConIdText" value="<%out.print(str);%>" style="display: none" /><br />


<%--<div id="qrcode" style="width:100px; height:100px; margin-top:15px;"></div>--%>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 317px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    二维码
                </h4>
            </div>
            <div class="modal-body" id="qrcode" style="width:120px; height:150px; margin: 0  auto;padding: 0 auto;">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<script type="text/javascript">
    var qrcode = new QRCode(document.getElementById("qrcode"), {

        width : 100,
        height : 100
    });

    function makeCode () {
        var elText = document.getElementById("text");
        var test = new String(elText);
        if (!elText.value) {
            alert("Input a text");
            elText.focus();
            return;
        }

        qrcode.makeCode(elText.value);
    }
    makeCode ();

    $("#text").
    on("blur", function () {
        makeCode();
    }).
    on("keydown", function (e) {
        if (e.keyCode == 13) {
            makeCode();
        }
    });
</script>
<%--------------------------------------------------------------------%>

</body>
</html>
