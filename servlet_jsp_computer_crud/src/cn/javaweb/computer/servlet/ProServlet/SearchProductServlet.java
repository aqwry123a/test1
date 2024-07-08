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
import java.util.List;

/**
 * 功能：模糊查询 根据电脑名查


 */
@WebServlet("/searchProduct")

public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keword = req.getParameter("keyword");
        keword = new String(keword.getBytes("iso8859-1"),"utf-8");
        ProductDao dao = new ProductDaoImpI();
        List<Product> products = dao.searchByName(keword);
        req.setAttribute("products", products);
        req.getRequestDispatcher("productlist.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }


}
