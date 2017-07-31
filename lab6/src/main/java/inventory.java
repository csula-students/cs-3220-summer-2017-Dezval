import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(loadOnStartup=1, urlPatterns={"/inventory"})
public class inventory extends HttpServlet {

//    public void init(){
//        List<FoodEntry> entries = new ArrayList<>();
//        entries.add(new FoodEntry(entries.size(), "Apple pie", 11.99, "description TBA"));
//        entries.add(new FoodEntry(entries.size(), "Pumpkin Pie", 11.99, "description TBA"));
//        getServletContext().setAttribute("entries", entries);
//    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        foodDAO dao = new foodDAO();
        request.setAttribute("entries", dao.list());
        request.getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);

    }
}
