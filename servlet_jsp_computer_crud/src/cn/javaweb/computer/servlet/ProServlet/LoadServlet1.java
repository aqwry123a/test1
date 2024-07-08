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


    @WebServlet("/load1")//将Servlet映射到Web应用程序中的路径 "/load1"
    public class LoadServlet1 extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            ProductDao dao = new ProductDaoImpI();
            //创建一个 ProductDao 接口的实例，通常用于与数据库进行交互。这里使用了一个名为 ProductDaoImpI 的实现类的实例。
            Product product = dao.findByID(id);
            //通过调用 dao.findByID(id) 方法，从数据库中获取具有指定ID的产品对象。
            req.setAttribute("product", product);//设置属性值，然后在同一个请求范围内的JSP页面中使用
            req.getRequestDispatcher("updateproduct.jsp").forward(req, resp);//Servlet 中用于将请求转发到另一个资源
        }
    }

