package com.dao;

import cn.hutool.crypto.digest.DigestUtil;
import com.pojo.Pojo;

import java.sql.*;

public class UserDAO {
    public Pojo Login(String username, String password) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.211.200/s77-zyx","root","sasa");
        //写sql语句
        String sql  = "select id,username,password from users where username=? and password=?;";
        //创建命令对象
        PreparedStatement ps = con.prepareStatement(sql);
        String pwd = DigestUtil.md5Hex(password);
        ps.setString(1,username);
        ps.setString(2,pwd);
        //发送
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Pojo user = new Pojo();
            user.setId(id);
            user.setUsername(name);
            con.close();
            return user;
        }
        con.close();
        return null;
    }



}
