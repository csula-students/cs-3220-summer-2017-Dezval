import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@WebServlet("addToOrders")
public class AddToOrders extends HttpServlet {
    public void init() {
        List<Order> ordersList = new ArrayList<>();
        getServletContext().setAttribute("ordersList", ordersList);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList = (List<Order>) getServletContext().getAttribute("ordersList");
        List<Order> cartItems = (List<Order>) getServletContext().getAttribute("cartItems");

        while(!cartItems.isEmpty()){
            ordersList.add(
                    new Order(
                            ordersList.size(),
                            cartItems.get(0).getItem(),
                            cartItems.get(0).getCustomerName(),
                            Order.Status.IN_QUEUE,
                            cartItems.get(0).getCreated()
                    )
            );
            cartItems.remove(0);
        }
        getServletContext().setAttribute("ordersList", ordersList);

        response.sendRedirect("orders");
    }
}
