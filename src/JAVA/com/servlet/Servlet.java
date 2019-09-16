package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Student1;
import com.pojo.Student;

public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tz = request.getParameter("I");
        if(tz.equals("main")){
            doStudent(request,response);

        }
    }

    private void doStudent(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        Student1 sd = new Student1();
        ArrayList<Student> pojo =  (ArrayList<Student>) sd.findALL();
        for (Student s:pojo) {
            System.out.printf(s.getSid()+"   "+s.getSname());
        }
        request.setAttribute("pojo", pojo);
        request.getRequestDispatcher("main.jsp").forward(request, response);


    }
}
