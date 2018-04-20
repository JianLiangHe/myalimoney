package edu.myalimoney.filter;

import edu.myalimoney.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    //允许不用过滤器的路径
    private final String ALLOWURL = "/index.jsp,/loginController/login.do";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取访问路径
        String requestPath = request.getServletPath();

        //过滤
        if(ALLOWURL.indexOf(requestPath)>=0||requestPath.endsWith(".css")||requestPath.endsWith(".js")||requestPath.endsWith(".jpg")||requestPath.endsWith(".png")){
            filterChain.doFilter(request, response);
        }else{
            //获取登陆用户
            User user = (User) request.getSession().getAttribute("loginUser");
            //判断用户是否登陆
            if(user==null){
                PrintWriter out = response.getWriter();
                String url = request.getContextPath()+"/index.jsp";
                out.print("<script>location.href='"+url+"'</script>");
                out.close();
            }
            filterChain.doFilter(request, response);
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
