package com.powernode.servlet;

import com.powernode.jdbc.EmpJDBC;
import com.powernode.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/listEmp")
public class ListEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpJDBC empJDBC = new EmpJDBC();
       List<Emp> empList= empJDBC.getAll();
       req.setAttribute("empList",empList);
       req.getRequestDispatcher("listEmp.jsp").forward(req,resp);
    }
}
