package edu.myalimoney.controller;

import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.exception.LoginException;
import edu.myalimoney.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController {

    //声明业务层

    @ResponseBody
    @RequestMapping(value = "login.do")
    public RtnResult doLogin(User user){
        RtnResult result = new RtnResult();
        try {

        } catch (LoginException e) {

        } finally {
            return result;
        }
    }

}
