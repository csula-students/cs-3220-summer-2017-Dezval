package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@WebServlet("/jdbc/guestbook/update")
public class UpdateGuestBook extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        GuestBookDAO dao = new GuestBookDAO();
        GuestBookEntry entry = dao.list().get(Integer.parseInt(id));
        dao.update(entry);
        request.setAttribute("entry", entry);

        request.getRequestDispatcher("/WEB-INF/jdbc/guestbook-update.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String comment = request.getParameter("comment");
        GuestBookDAO dao = new GuestBookDAO();
        GuestBookEntry newEntry = new GuestBookEntry(-1, name, comment, dao.list().size());


        dao.add(newEntry);
        response.sendRedirect("../guestbook");
    }
}
