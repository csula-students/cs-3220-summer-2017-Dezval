package jdbc;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;



@WebServlet("/jdbc/guestbook/create")
public class CreateGuestBookServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jdbc/guestbook-add.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String comment = request.getParameter("comment");

//        newEntry.setCreated(Date.from(Instant.EPOCH));

        GuestBookDAO dao = new GuestBookDAO();
        GuestBookEntry newEntry = new GuestBookEntry(dao.list().size(), name, comment,dao.list().size());
        dao.add(newEntry);
        response.sendRedirect("../guestbook");
    }
}