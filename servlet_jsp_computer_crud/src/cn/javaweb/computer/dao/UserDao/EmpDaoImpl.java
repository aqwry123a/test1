package cn.javaweb.computer.dao.UserDao;


import cn.javaweb.computer.entity.UserEntity.Emp;
import cn.javaweb.computer.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> findALL() {
        /*
         * 1. 创建空的容器，ArrayList
         * 2. JDBC
         * 3. 返回这个容器
         * */
        List<Emp> emps = new ArrayList<Emp>();
        // 1. 加载驱动，获得链接
        // 2. 获得用于执行SQL的对象，执行SQL，获得结果集
        // 3. 处理结果集：吧结果集中的记录封装成若干个对象，依次放入集合
        // 4. 关闭链接
        Connection con = DbUtil.getCon();
        String sql = "select * from employee";
        Statement stmt = null; // 用于执行SQL语句
        ResultSet rs = null; // 存储结果集

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                double salary = rs.getDouble("SALARY");
                String job = rs.getString("JOB");

                Emp emp = new Emp(id, name, salary, job);
                emps.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtil.closeCon(con);
        }
        return emps;
    }

    @Override
    public boolean save(Emp emp) {
        boolean flag = true; // 初始情况下，默认插入成功
        /*
         * 获得连接
         * 获得用于执行sql的对象
         * insert into employee value( , , );
         * 执行SQL，会得到一个整数，表示对多少行产生了影响
         */
        Connection con = DbUtil.getCon();
        /* 在 Java 中，PreparedStatement 是一个接口，它继承自 Statement 接口，用于执行 SQL 查询和更新语句.
        并且可以预编译 SQL 语句，防止 SQL 注入攻击。*/
        PreparedStatement pst = null;
        String sql = "insert into employee(name, salary, job) values(?,?,?)";
//      "insert into employee(name, salary, job) values('" + emp.getName() + "'," + emp.getSalary() + ",'" + emp.getJob() + "');";
        try {
//         stmt = con.createStatement();
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getName());
            pst.setDouble(2, emp.getSalary());
            pst.setString(3, emp.getJob());
            pst.executeUpdate();
        } catch (SQLException e) {
            flag = false;
            throw new RuntimeException(e);
        } finally {
            DbUtil.closeCon(con);
        }
        return flag;
    }

    @Override
    public void deleteById(int id) {
        Connection con = DbUtil.getCon();
        PreparedStatement pst = null;
        String sql = "delete from employee where id = ?;"; // 防止SQL注入

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
    public boolean updateById(Emp emp) {
        Connection con = DbUtil.getCon();
        PreparedStatement pst = null;
        String sql = "update employee SET name=?, salary=?, job=? where id=?;";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, emp.getName());
            pst.setDouble(2, emp.getSalary());
            pst.setString(3, emp.getJob());
            pst.setInt(4, emp.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeCon(con);
        }
        return false;
    }

    @Override
    public List<Emp> searchByName(String keyword) {
        List<Emp> empList = new ArrayList<>();
        Connection con = DbUtil.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            /*设置了参数值。这里的 setString 方法用于给 ? 占位符绑定值。1 表示第一个参数（SQL 中的第一个问号）
            "%" + keyword + "%" 是实际的查询关键字。
            % 表示通配符，用于模糊查询，keyword 是用于查询的关键字。*/

            String query = "SELECT * FROM employee WHERE name LIKE ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 从结果集中获取数据并创建 Emp 对象，假设表的列名为 id、name、salary、job
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                String job = resultSet.getString("job");
                //new emp对象
                Emp emp = new Emp(id, name, salary, job);
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 处理异常
        } finally {
            // 关闭资源
            DbUtil.closeCon(con);
        }
        return empList;
    }


    @Override
    public Emp findByID(int id) {
        Connection con = DbUtil.getCon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Emp emp = new Emp();
        String sql = "select * from employee where id = ?;";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("NAME");
                double salary = rs.getDouble("SALARY");
                String job = rs.getString("JOB");

                emp = new Emp(id, name, salary, job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeCon(con);
        }

        return emp;
    }
}
