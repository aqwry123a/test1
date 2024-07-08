package cn.javaweb.computer.dao.ProductDao;

import cn.javaweb.computer.entity.ProEntity.Product;
import cn.javaweb.computer.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpI implements ProductDao {
   @Override
        public List<Product> findALL() {
       List<Product> products = new ArrayList<Product>();
            Connection con = DbUtil.getCon();
            String sql = "select * from product";//表
            Statement stmt = null; // 用于执行SQL语句
            ResultSet rs = null; // 存储结果集
           try {
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                // 处理结果集product
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("NAME");
                    String brand = rs.getString("BRAND");
                    String price = rs.getString("PRICE");
                    Product product = new Product(id,name,brand, price);
                    products.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DbUtil.closeCon(con);
            }
            return products;
        }

   @Override
   public boolean insert(Product product) {
       boolean flag = false;  // 初始化为 false
       Connection conn = DbUtil.getCon();
       PreparedStatement pstmt = null;
       String sql = "insert into product(id, name, price, brand) values (?, ?, ?, ?)";

       try {
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, product.getId());
           pstmt.setString(2, product.getName());
//           pstmt.setString(4, product.getPrice());
           pstmt.setDouble(3, Double.parseDouble(product.getPrice()));
           pstmt.setString(4, product.getBrand());
           int rowsAffected = pstmt.executeUpdate();

           // 检查是否成功插入了记录
           if (rowsAffected > 0) {
               flag = true;
           }
       } catch (Exception e) {
           // 处理异常
           throw new RuntimeException(e);
       } finally {
           // 关闭资源
           DbUtil.closeCon(conn);
       }

       return flag;
   }


    @Override
    public boolean update(Product product) {
       //这是一个公共方法，返回一个布尔值。它接受一个名为 Product 的参数，表明该方法用于更新产品信息。
        Connection conn = null;
        boolean flag = true;
        //flag: 一个布尔变量，可能用于表示更新是否成功。
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getCon();
            String sql = "update product SET name=?,price=?,brand=? where id=?";
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, product.getName()): 设置 SQL 语句中的第一个参数为产品的名称。
            pstmt.setString(1, product.getName());
            // 将字符串转换为 double 类型
            double price = Double.parseDouble(product.getPrice());
            // 设置参数为 double
            pstmt.setDouble(2, price);
            pstmt.setString(3, product.getBrand());
            pstmt.setInt(4, product.getId());

            pstmt.executeUpdate();
            }catch (Exception e) {
            //异常处理：如果在更新过程中发生异常，异常信息将被打印。
            e.printStackTrace();
        }finally {
    DbUtil.closeCon(conn);
}
            return false;

    }

        @Override
        public void deleteById(int id) {
            Connection con = DbUtil.getCon();
            PreparedStatement pst = null;
            String sql = "delete from product where id = ?;"; // 防止SQL注入

            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);

                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtil.closeCon(con);
            }
        }
        @Override
        public List<Product> searchByName(String keyword) {
            List<Product> proList = new ArrayList<>();
            Connection con = DbUtil.getCon();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
            /*设置了参数值。这里的 setString 方法用于给 ? 占位符绑定值。1 表示第一个参数（SQL 中的第一个问号）
            "%" + keyword + "%" 是实际的查询关键字。
            % 表示通配符，用于模糊查询，keyword 是用于查询的关键字。*/
                String query = "SELECT * FROM product WHERE name LIKE ?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, "%" + keyword + "%");
                //preparedStatement.setString(1, "%" + keyword + "%"): 设置 SQL 语句中的参数，实现模糊查询。
                resultSet = preparedStatement.executeQuery();
                //resultSet = preparedStatement.executeQuery(): 执行查询操作，并将结果存储在 resultSet 中。

                while (resultSet.next()) {
                    // 从结果集中获取数据并创建 Emp 对象，假设表的列名为 id、name、salary、job
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                String price = resultSet.getString("price");

                    // 设置参数为 double
                    String brand= resultSet.getString("brand");
                    //new emp对象
                    Product product = new Product(id,name,price, brand);
                    proList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // 处理异常
            } finally {
                // 关闭资源
                DbUtil.closeCon(con);
            }
            return proList;
        }
        @Override
        public Product findByID(int id) {
            Connection con = DbUtil.getCon();
            PreparedStatement pst = null;
            ResultSet rs = null;
            Product product = new Product();
            String sql = "select * from product where id = ?;";
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {

                    String name = rs.getString("NAME");
                    String price = rs.getString("PRICE");
                    String brand = rs.getString("BRAND");

                    product = new Product();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtil.closeCon(con);
            }

            return product;
        }
    }


