package com.contact;

import ContactDao.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        PrintWriter out = res.getWriter();


        LoginDao dao = new LoginDao();
        if(dao.getData(name,password)){
            RequestDispatcher rd = req.getRequestDispatcher("/request");
            rd.forward(req,res);
//            res.sendRedirect("request");
//            res.sendRedirect("../admin/contactus/request.jsp");
        }
        else{
            out.println("invalid login");
        }

    }

}
