package cn.javaweb.computer.dao.UserDao;


import cn.javaweb.computer.entity.UserEntity.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * 查询所有员工
     */
    public List<Emp> findALL();

    /**
     * 通过id查询一个员工
     */
    public Emp findByID(int id);

    public boolean save(Emp emp);

    public void deleteById(int id);

    public boolean updateById(Emp emp);


    List<Emp> searchByName(String keyword);
}
