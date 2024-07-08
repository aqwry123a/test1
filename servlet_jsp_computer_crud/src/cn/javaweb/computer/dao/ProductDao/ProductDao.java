package cn.javaweb.computer.dao.ProductDao;

import cn.javaweb.computer.entity.ProEntity.Product;

import java.util.List;

public interface ProductDao {

        public List<Product> findALL();
      public  boolean insert(Product product);
      /**
         * 通过id查询一个电脑
         */
        public Product findByID(int id);
 public   boolean update(Product product);
    public void deleteById(int id);

        List<Product> searchByName(String keyword);
    }


