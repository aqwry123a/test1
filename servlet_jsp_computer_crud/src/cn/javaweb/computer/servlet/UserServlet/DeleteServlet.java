package cn.javaweb.computer.servlet.UserServlet;

import cn.javaweb.computer.dao.UserDao.EmpDao;
import cn.javaweb.computer.dao.UserDao.EmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/del")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EmpDao dao = new EmpDaoImpl();
        dao.deleteById(id);
        resp.sendRedirect("list");
    }
}
