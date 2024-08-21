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
        String fullName = req.getParameter("fullName");
        String Email = req.getParameter("email");
        String Message = req.getParameter("message");
        ContactUsDao dao = new ContactUsDao();
        dao.insertContactData(fullName,Email,Message);
        res.sendRedirect("request");

    }
}
