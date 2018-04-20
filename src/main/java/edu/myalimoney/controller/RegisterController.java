package edu.myalimoney.controller;

import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.exception.UserException;
import edu.myalimoney.pojo.User;
import edu.myalimoney.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理用户注册的控制器
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    //声明业务层
    @Autowired
    private IUserService iUserService;

    /**
     * 处理用户注册的请求
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register.do")
    public RtnResult doRegister(User user){
        RtnResult result = new RtnResult();
        try {
            iUserService.saveUser(user);
            result.setMessage("注册成功.");
        } catch (UserException e) {
            result.setCode(400);
            result.setMessage(e.getMessage());
        } finally {
            return result;
        }
    }

}
