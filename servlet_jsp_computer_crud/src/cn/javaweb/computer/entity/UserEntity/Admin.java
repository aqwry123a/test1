package cn.javaweb.computer.entity.UserEntity;

/**
 * 管理员
 */
public class Admin {
    private String username;
    private String name;
    private String pwd;
    private int sex;

    public Admin() {
    }

    public Admin(String username, String name, String password, int sex) {
        this.username = username;
        this.name = name;
        this.pwd = password;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
