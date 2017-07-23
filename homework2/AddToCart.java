package homework2;

import lab3.FoodEntry;

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

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        orders.add(new Order(orders.size(), entries.get(id), "Customer Name", Order.Status.IN_QUEUE, Date.from(Instant.EPOCH)));
        getServletContext().setAttribute("orders", orders);

        response.sendRedirect("menu");

    }
}