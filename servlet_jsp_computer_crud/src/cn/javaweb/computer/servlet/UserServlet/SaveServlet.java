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

/**
 * 功能：添加用户

 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 从请求对象包好的表单中拿出那四个数据
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String job = req.getParameter("job");
        // 封装成一个emp对象
        Emp emp = new Emp(name, salary, job);
        // 持久化
        EmpDao dao = new EmpDaoImpl();
        boolean flag = dao.save(emp);
        // 根据持久化返回的结果，做不同的响应
        if (flag == false) {
            resp.sendRedirect("fail.jsp");
        } else {
            resp.sendRedirect("list");
        }
    }
}
