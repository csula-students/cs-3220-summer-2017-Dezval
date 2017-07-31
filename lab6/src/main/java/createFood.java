

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
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/createFood.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

//        newEntry.setCreated(Date.from(Instant.EPOCH));

        foodDAO dao = new foodDAO();
        FoodEntry newEntry = new FoodEntry(dao.list().size()+1, name, price, description);
        dao.add(newEntry);
        response.sendRedirect("inventory");
    }

}
