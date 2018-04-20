package edu.myalimoney.service.impl;

import edu.myalimoney.dao.IUserDao;
import edu.myalimoney.exception.LoginException;
import edu.myalimoney.pojo.User;
import edu.myalimoney.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 处理登陆相关业务的实现类
 */
@Service("iLoginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements ILoginService {

    //声明Dao
    @Autowired
    private IUserDao iUserDao;

    /**
     * 执行方法
     * @param user
     * @return
     */
    @Override
    public User excute(User user) {
        return findUser(user);
    }

    /**
     * 查询用户
     * @param user
     * @return
     */
    private User findUser(User user){
        User dataUser = iUserDao.findUserByAccount(user.getAccount());
        if(dataUser!=null){
            return checkLoginUser(user,dataUser);
        }
        throw new LoginException("该账号不存在.");
    }

    /**
     * 验证登陆用户
     * @param user1 登陆用户
     * @param user2 数据库查询出来的用户
     * @return
     */
    private User checkLoginUser(User user1, User user2){
        if(user1.getPassword().equals(user2.getPassword())){
            if(user2.getStatus()==1){
                return user2;
            }
            throw new LoginException("该用户已禁用.");
        }
        throw new LoginException("账号与密码有误.");
    }

}
