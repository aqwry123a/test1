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
import java.util.List;



@WebServlet("/searchEmp")
//可以指定这个Servlet与路径 "/searchEmp"相关联从而使得在浏览器中访问 "/searchEmp" 时，
// 容器将调用 SearchEmpServlet 来处理请求。



public class SearchEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = dao.searchByName(keyword);
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("emplist.jsp").forward(req, resp);
    }


}
