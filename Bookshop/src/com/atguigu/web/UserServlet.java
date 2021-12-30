package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();



    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = new User(null,username,password,null);
        if(userService.Login(loginUser)!=null){
            loginUser = userService.Login(loginUser);
            req.getSession().setAttribute("user",loginUser);
            System.out.println("Login successfully!");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            req.setAttribute("errorMsg","用户或密码错误!");
            req.setAttribute("userName",username);
            System.out.println("Fail to login!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.CopyParamToBean(req, new User());

        if (token!=null && token.equalsIgnoreCase(code)) {
            if (userService.exitsUsername(username)) {
                req.setAttribute("errorMsg", "用户名已存在！！");
                req.setAttribute("userName", username);
                req.setAttribute("email", email);
                System.out.println("用户名 " + username + " 已经存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(user);
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("errorMsg", "验证码错误！！");
            req.setAttribute("userName", username);
            req.setAttribute("email", email);
            System.out.println("验证码 " + code + " 错误!");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}
