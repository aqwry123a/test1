package cn.javaweb.computer.servlet.ProServlet;
import cn.javaweb.computer.dao.ProductDao.ProductDao;
import cn.javaweb.computer.dao.ProductDao.ProductDaoImpI;
import cn.javaweb.computer.entity.ProEntity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));//返回的是一个字符串类型的值要强转
        String name = req.getParameter("name");//请求响应参数
        String price = req.getParameter("price");
        String brand= req.getParameter("brand");
        ProductDao dao = new ProductDaoImpI();//构造方法
        //创建一个对象
        Product product = new Product(id, name,price, brand);
        dao.update(product);//
        resp.sendRedirect("list1");//重定向跳转到list1
    }
}

