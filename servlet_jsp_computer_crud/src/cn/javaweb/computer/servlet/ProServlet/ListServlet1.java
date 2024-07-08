package cn.javaweb.computer.servlet.ProServlet;

import cn.javaweb.computer.dao.ProductDao.ProductDao;
import cn.javaweb.computer.dao.ProductDao.ProductDaoImpI;
import cn.javaweb.computer.dao.UserDao.EmpDao;
import cn.javaweb.computer.dao.UserDao.EmpDaoImpl;
import cn.javaweb.computer.entity.ProEntity.Product;
import cn.javaweb.computer.entity.UserEntity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list1")  //请求这里
public class ListServlet1 extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过dao和数据库交互，得到一个集合
        ProductDao dao = new ProductDaoImpI();
        List<Product> products = dao.findALL();
        // 将集合绑定到请求对的中，再向下一个servlet发送请求,emplist.jsp
        req.setAttribute("products", products);//吧数据放到request中
        req.getRequestDispatcher("productlist.jsp").forward(req, resp);//跳转页面
    }
}

