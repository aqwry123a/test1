package cn.javaweb.computer.dao.UserDao;


import cn.javaweb.computer.entity.UserEntity.Admin;
import cn.javaweb.computer.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin login(String username, String password) {
        //连接数据库,获取数据
        //封装成对象
        Connection con = DbUtil.getCon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Admin admin = null;
        // SQL查询语句
        String sql = "select * from admin where username = ? and password = ?;";
        try {
            // 创建PreparedStatement对象
            pst = con.prepareStatement(sql);
            //设置查询参数
            pst.setString(1, username);
            pst.setString(2, password);
            //返回返回值要更新的行数
            rs = pst.executeQuery();
            while (rs.next()) {
                //获得查询结果中的姓名和性别然后new一个admin对象
                String name = rs.getString("NAME");
                int sex = rs.getInt("SEX");
                admin = new Admin(username, name, password, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            DbUtil.closeCon(con);
        }
        // 返回查询到的Admin对象
        return admin;
    }

    @Override
    public boolean register(String username, String name, String password, int sex) {
        // 初始化标志为true，表示注册成功
        boolean flag = true;

        Connection con = DbUtil.getCon();
        PreparedStatement pst = null;
        String sql = "insert into admin(username, name, password, sex) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            // 设置插入参数
            pst.setString(1, username);
            pst.setString(2, name);
            pst.setString(3, password);
            pst.setInt(4, sex);
            pst.executeUpdate();   // 执行插入操作
        } catch (SQLException e) {

            // 发生异常时，将标志设置为false，并抛出运行时异常
            flag = false;
            throw new RuntimeException(e);
        } finally {
            DbUtil.closeCon(con);
        }
        // 返回注册结果标志
        return flag;
    }

}