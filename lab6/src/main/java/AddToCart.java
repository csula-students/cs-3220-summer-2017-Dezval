

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@WebServlet("/addToCartJSP")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Order> cartItems = (List<Order>) getServletContext().getAttribute("cartItems");
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        cartItems.add(new Order(cartItems.size(), entries.get(Integer.parseInt(id)), "Customer Name", Order.Status.IN_QUEUE, Date.from(Instant.EPOCH)));
        getServletContext().setAttribute("cartItems", cartItems);

        response.sendRedirect("index");

    }
}