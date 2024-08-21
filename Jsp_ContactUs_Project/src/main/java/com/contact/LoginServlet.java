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
    public void service(HttpServletRequest req, HttpServletResponse res)  {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginDao dao = new LoginDao();
        if (dao.getData(name, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            RequestDispatcher rd = req.getRequestDispatcher("/request");
            try {
                rd.forward(req, res);
            } catch (ServletException e) {
               e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            out.println("invalid login");
        }

    }

}
