package cn.javaweb.computer.servlet.ProServlet;


import cn.javaweb.computer.dao.ProductDao.ProductDao;
import cn.javaweb.computer.dao.ProductDao.ProductDaoImpI;
import cn.javaweb.computer.dao.UserDao.AdminDao;
import cn.javaweb.computer.dao.UserDao.AdminDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ProductDao productDao=new ProductDaoImpI();
        //获取前端传来的参数
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String price = req.getParameter("price");
if(name!=null&&id!=null&&brand!=null&&price!=null)
        {
           resp.sendRedirect("productlist.jsp");

        }else

            resp.sendRedirect("fail.jsp");
        }

        }


