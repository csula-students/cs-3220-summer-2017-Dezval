import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("deleteJSP")
public class deleteFood extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        int index = -1;
        for (int i = 0; i < entries.size(); i ++) {
            if (entries.get(i).getId() == id) {
                index = i;
            }
        }
        entries.remove(index);
        getServletContext().setAttribute("entries", entries);

        response.sendRedirect("inventory");
    }
}
