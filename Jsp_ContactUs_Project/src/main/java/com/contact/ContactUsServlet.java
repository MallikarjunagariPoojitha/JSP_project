package com.contact;

import ContactDao.ContactUsDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/insertData")
public class ContactUsServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String FullName = req.getParameter("fullname");
        String Email = req.getParameter("email");
        String Message = req.getParameter("message");
        ContactUsDao dao = new ContactUsDao();
        dao.insertContactData(FullName,Email,Message);
        res.sendRedirect("success.jsp");

    }
}
