import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("removeFromCartJSP")
public class removeFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Order> cartItems = (List<Order>) getServletContext().getAttribute("cartItems");
        int index = -1;
        for (int i = 0; i < cartItems.size(); i ++) {
            if (cartItems.get(i).getId() == id) {
                index = i;
            }
        }
        cartItems.remove(index);
        getServletContext().setAttribute("cartItems", cartItems);

        response.sendRedirect("cart");

    }
}
