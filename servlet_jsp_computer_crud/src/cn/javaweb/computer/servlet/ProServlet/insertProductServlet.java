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

/**
 */
@WebServlet("/insertProduct")
public class insertProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String price = req.getParameter("price");
        // 封装成一个emp对象
        Product product = new Product(id,name, brand, price);
        // 持久化
        ProductDao dao = new ProductDaoImpI();
        boolean flag = dao.insert(product);
        // 根据持久化返回的结果，做不同的响应
        if (flag == false) {
            resp.sendRedirect("fail.jsp");
        } else {
            resp.sendRedirect("list1");
        }
    }
}
