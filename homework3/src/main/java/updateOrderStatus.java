import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@WebServlet("updateOrderStatus")
public class updateOrderStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/updateOrderStatus.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList = (List<Order>) getServletContext().getAttribute("ordersList");
        int id = Integer.parseInt(request.getParameter("id"));

        ordersList.set(id,new Order(
                id,
                ordersList.get(id).getItem(),
                ordersList.get(id).getCustomerName(),
                Order.Status.valueOf(request.getParameter("status")),
                Date.from(Instant.EPOCH)
        ));
        getServletContext().setAttribute("ordersList", ordersList);

        response.sendRedirect("orderStatuses");
    }
}
