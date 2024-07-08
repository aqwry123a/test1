package cn.javaweb.computer.servlet.UserServlet;

import cn.javaweb.computer.dao.UserDao.AdminDao;
import cn.javaweb.computer.dao.UserDao.AdminDaoImpl;
import cn.javaweb.computer.entity.UserEntity.Admin;
import com.sun.jmx.interceptor.DefaultMBeanServerInterceptor;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 创建AdminDao实例
        AdminDao adminDao = new AdminDaoImpl();
        if(username.equals("1")&&password.equals("1")) {
            resp.sendRedirect("fail.jsp");

        } else {
            resp.sendRedirect("index.jsp");
        }

    }
}