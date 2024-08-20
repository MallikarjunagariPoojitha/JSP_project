package com.contact;

import ContactDao.ActiveToArchiveDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/archive")
public class ActiveServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ActiveToArchiveDao dao = new ActiveToArchiveDao();
        int id = Integer.parseInt(req.getParameter("id"));
        dao.updateStatus(id);
//        RequestDispatcher rd = req.getRequestDispatcher("/updateArchive");
//        rd.forward(req,res);
        res.sendRedirect("archiveUpdate.jsp");

    }

}
