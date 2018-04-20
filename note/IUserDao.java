package edu.myalimoney.dao;

import edu.myalimoney.pojo.User;

/**
 * 定义用户相关数据操作的Dao
 */
public interface IUserDao {

    //根据账号查询用户
    User findUserByAccount(String account);

}
