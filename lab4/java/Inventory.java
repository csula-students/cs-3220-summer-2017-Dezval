import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup = 1, urlPatterns = { "/foods" })
public class Inventory extends HttpServlet {

    public void init() {
        List<FoodEntry> inventory = new ArrayList<>();

        getServletContext().setAttribute("inventory", inventory);
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FoodEntry> inventory = (List<FoodEntry>) getServletContext().getAttribute("inventory");
        request.setAttribute("inventory", inventory);
        request.getRequestDispatcher("/inventory.jsp")
                .forward(request, response);
    }
}