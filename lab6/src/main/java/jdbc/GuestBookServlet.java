package jdbc;

/**
 * Created by Dezval on 7/29/2017.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/jdbc/guestbook")
public class GuestBookServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GuestBookDAO dao = new GuestBookDAO();
        request.setAttribute("list", dao.list());
        request.getRequestDispatcher("/WEB-INF/jdbc/guestbook.jsp").forward(request, response);
    }
}
