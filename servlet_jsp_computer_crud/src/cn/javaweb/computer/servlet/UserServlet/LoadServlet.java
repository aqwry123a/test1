package cn.javaweb.computer.servlet.UserServlet;

import cn.javaweb.computer.dao.UserDao.EmpDao;
import cn.javaweb.computer.dao.UserDao.EmpDaoImpl;
import cn.javaweb.computer.entity.UserEntity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/load")
public class LoadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这是一个Java Servlet类，名为LoadServlet，用于处理HTTP请求，
        // 并通过调用EmpDao实现类的方法从数据库中获取特定ID的员工信息，然后将该信息设置为请求属性，最后将请求转发到updateEmp.jsp页面。
        int id = Integer.parseInt(req.getParameter("id"));
        EmpDao dao = new EmpDaoImpl();
        Emp emp = dao.findByID(id);
        req.setAttribute("emp", emp);//设置属性值，然后在同一个请求范围内的JSP页面中使用
        req.getRequestDispatcher("updateEmp.jsp").forward(req, resp);//Servlet 中用于将请求转发到另一个资源
    }
}
