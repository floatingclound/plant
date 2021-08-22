package com.powernode.servlet;

import com.powernode.jdbc.UserJDBC;
import com.powernode.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserJDBC userJDBC = new UserJDBC();
        User user = new User(username, password);
        boolean checkLogin = userJDBC.checkLogin(user);
        if(checkLogin){
              request.getSession().setAttribute("user",user);
              request.getRequestDispatcher("listEmp").forward(request,response);
        }else{
             request.setAttribute("msg","账号和密码错误");
             request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
