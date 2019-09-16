package com.servlet;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.dao.UserDAO;
import com.pojo.Pojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UsersServlet")
public class UsersServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String yzm = request.getParameter("yzm");
        QrCodeUtil.generate("user:admin password123456", 300, 300, FileUtil.file("d:/IDEA Project/New/src/main/webapp/img/qrcode.jpg"));
        String sessionyzm  = (String)request.getSession().getAttribute("code");
        if (sessionyzm.equalsIgnoreCase(yzm)==false){
            response.getWriter().println("<script>alert('验证码错误');</script>");
            response.getWriter().println("<script>location='login.jsp';</script>");
            return;
        }

        try {
            Pojo user = dao.Login(username,password);
            if (user!=null){
                request.getSession().setAttribute("users",user);
                response.getWriter().println("登陆成功");
                return;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().println("<script>alert('用户名或密码错误');</script>");
        response.getWriter().println("<script>location='login.jsp';</script>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
