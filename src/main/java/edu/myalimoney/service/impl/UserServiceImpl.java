package edu.myalimoney.service.impl;

import edu.myalimoney.dao.IUserDao;
import edu.myalimoney.exception.UserException;
import edu.myalimoney.pojo.User;
import edu.myalimoney.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 处理用户相关业务的实现类
 */
@Service("iUserService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

    //声明Dao
    @Autowired
    private IUserDao iUserDao;

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        if(iUserDao.findUserByAccount(user.getAccount())!=null) throw new UserException("该用户已存在.");
        try {
            iUserDao.save(user);
        } catch (RuntimeException e) {
            throw new UserException("新增用户失败.");
        }
    }

}
