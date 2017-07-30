import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dezval on 7/29/2017.
 */
@WebServlet("createFoodJSP")
public class createFood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/createFood.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        int id = entries.size();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        entries.add(new FoodEntry(id, name, price, description));
        getServletContext().setAttribute("entries", entries);

        response.sendRedirect("inventory");
    }
}
