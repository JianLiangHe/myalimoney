package edu.myalimoney.controller;

import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.exception.LoginException;
import edu.myalimoney.exception.UserException;
import edu.myalimoney.pojo.User;
import edu.myalimoney.service.ILoginService;
import edu.myalimoney.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    //声明业务层
    @Autowired
    private ILoginService iLoginService;

    /**
     * 处理用户登陆的请求
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login.do")
    public RtnResult doLogin(HttpServletRequest request, User user){
        try {
            user = iLoginService.excute(user);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            return new RtnResult(WebUtils.SUCCESS_RESULT, WebUtils.SUCCESS_STATUS, "登陆成功.");
        } catch (LoginException e) {
            return new RtnResult(WebUtils.ERROR_RESULT, WebUtils.ERROR_STATUS, e.getMessage());
        }
    }

}
