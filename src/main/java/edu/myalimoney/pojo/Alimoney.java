package edu.myalimoney.pojo;

import java.io.Serializable;

/**
 * 封装生活费信息的实体类
 */
public class Alimoney implements Serializable {

    private int alimoney_no;//编号
    private String alimoney_title;//标题
    private String alimoney_info;//详细信息
    private double alimoney_money;//价格
    private String alimoney_createtime;//创建时间
    private int alimoney_status;//状态

    public Alimoney() {
    }

    public Alimoney(int alimoney_no, String alimoney_title, String alimoney_info, double alimoney_money, String alimoney_createtime, int alimoney_status) {

        this.alimoney_no = alimoney_no;
        this.alimoney_title = alimoney_title;
        this.alimoney_info = alimoney_info;
        this.alimoney_money = alimoney_money;
        this.alimoney_createtime = alimoney_createtime;
        this.alimoney_status = alimoney_status;
    }

    public int getAlimoney_no() {
        return alimoney_no;
    }

    public void setAlimoney_no(int alimoney_no) {
        this.alimoney_no = alimoney_no;
    }

    public String getAlimoney_title() {
        return alimoney_title;
    }

    public void setAlimoney_title(String alimoney_title) {
        this.alimoney_title = alimoney_title;
    }

    public String getAlimoney_info() {
        return alimoney_info;
    }

    public void setAlimoney_info(String alimoney_info) {
        this.alimoney_info = alimoney_info;
    }

    public double getAlimoney_money() {
        return alimoney_money;
    }

    public void setAlimoney_money(double alimoney_money) {
        this.alimoney_money = alimoney_money;
    }

    public String getAlimoney_createtime() {
        return alimoney_createtime;
    }

    public void setAlimoney_createtime(String alimoney_createtime) {
        this.alimoney_createtime = alimoney_createtime;
    }

    public int getAlimoney_status() {
        return alimoney_status;
    }

    public void setAlimoney_status(int alimoney_status) {
        this.alimoney_status = alimoney_status;
    }
}
