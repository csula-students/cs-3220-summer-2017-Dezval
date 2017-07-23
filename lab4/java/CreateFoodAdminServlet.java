
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/createFood.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        entries.add(new FoodEntry(entries.size(), request.getParameter("name"), Double.valueOf(request.getParameter("price")), request.getParameter("description")));
        getServletContext().setAttribute("entries", entries);

        response.sendRedirect("../../admin/foods");
    }
}