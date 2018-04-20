package edu.myalimoney.pojo;

import java.io.Serializable;

/**
 * 封装用户信息的实体类
 */
public class User implements Serializable {

    private int id;//编号
    private String account;//账号
    private String password;//密码
    private String createtime;//创建时间
    private String last_logintime;//最后登陆时间
    private int status = 1;//状态

    public User() {
    }

    public User(int id, String account, String password, String createtime, String last_logintime, int status) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.createtime = createtime;
        this.last_logintime = last_logintime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLast_logintime() {
        return last_logintime;
    }

    public void setLast_logintime(String last_logintime) {
        this.last_logintime = last_logintime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
