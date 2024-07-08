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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));//返回的是一个字符串类型的值要强转
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String job = req.getParameter("job");

        EmpDao dao = new EmpDaoImpl();
        Emp emp = new Emp(id, name, salary, job);
        dao.updateById(emp);
        resp.sendRedirect("list");
    }
}
