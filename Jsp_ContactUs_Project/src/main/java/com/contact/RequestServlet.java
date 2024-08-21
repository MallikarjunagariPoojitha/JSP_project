package com.contact;

import ContactDao.RequestDataDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ContactRequestData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDataDao dao = new RequestDataDao();
        List<ContactRequestData> requests = dao.getRequestData();
        req.setAttribute("requests", requests);
        RequestDispatcher rd = req.getRequestDispatcher("request.jsp");
        rd.forward(req,res);
    }

    //        if (requests == null) {
//            System.out.println("No requests found");
//        } else {
//            System.out.println("Requests found: " + requests.size());
//            for (ContactRequestData reqData : requests) {
//                System.out.println(reqData);
//            }
//        }



}
