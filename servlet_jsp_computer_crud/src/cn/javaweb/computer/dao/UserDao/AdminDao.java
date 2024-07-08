package cn.javaweb.computer.dao.UserDao;


import cn.javaweb.computer.entity.UserEntity.Admin;

public interface AdminDao {
    public Admin login(String username, String password);

    public boolean register(String username, String name, String password, int sex);
}

