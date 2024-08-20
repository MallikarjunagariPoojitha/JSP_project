package com.contact;

import ContactDao.ArchiveDataDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ArchiveRequestData;

import java.io.IOException;
import java.util.List;
@WebServlet("/archiveServlet")
public class ArchiveServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArchiveDataDao dao = new ArchiveDataDao();
        List<ArchiveRequestData> archiveRequestData = dao.getArchiveData();
        req.setAttribute("archiveRequests", archiveRequestData);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/request.jsp");
        rd.forward(req,res);

    }
}
