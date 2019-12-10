package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("GBk");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals(password)) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/error.html").forward(request, response);

        }
//        String address = request.getParameter("address");
//        String resume = request.getParameter("resume");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello world</title>");
        out.println("</head>");
        out.println("<body>");
//        out.println("用户名："+username+"<br>");
//        out.println("邮 箱："+email+"<br>");
//        out.println("地 址："+address+"<br>");
//        out.println("简 历："+resume+"<br>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }
}
