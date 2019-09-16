package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

public class Student1 {

    public List findALL(){
        List list = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.211.200/s77-zyx","root","sasa");
            //写sql语句
            String sql  = "select sid,sname from student;";
            //创建命令对象
            PreparedStatement ps = con.prepareStatement(sql);
            //发送
            ResultSet rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                Student stu = new Student();
                stu.setSid(sid);
                stu.setSname(sname);
                list.add(stu);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}

