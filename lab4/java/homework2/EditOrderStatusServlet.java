package homework2;

import lab3.FoodEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(loadOnStartup=1, urlPatterns={"/admin/order"})

public class EditOrderStatusServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Order> entries = (List<Order>) getServletContext().getAttribute("orders");
        Order leEntry = null;
        for(Order entry: entries){
            if(entry.getId() == id){
                leEntry = entry;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Edit Order</h1>");
        out.println("<form method =\"post\">");
        out.println("Food Entry name: " + leEntry.getItem().getName() + "</br>");
//        out.println("Price $: <input name='price' type='number' step='.01' value='"+ leEntry.getItem().getPrice() + "' /></br>");
//        out.println("Customer: <textarea name='customerName'>" + leEntry.getCustomerName() + "</textarea></br>");
//        out.println("<textarea name='description'>" + leEntry.getItem().getDescription() + "</textarea></br>");
        out.println("<select name='progress'>\n" +
                "  <option value='IN_QUEUE'>In Queue</option>\n" +
                "  <option value='IN_PROGRESS'>In Progress</option>\n" +
                "  <option value='COMPLETED'>Completed</option>\n" +
                "</select>");
        out.println("<button>Edit</button>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
        Order leEntry = null;
        int index = -1;
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getId() == id){
                leEntry = orders.get(i);
                index = i;
            }
        }

        Order.Status currentStatus = Order.Status.valueOf(request.getParameter("progress"));
        leEntry.setStatus(currentStatus);

//        leEntry.item.setName(request.getParameter("name"));
//        leEntry.setPrice(Double.valueOf(request.getParameter("price")));
//        leEntry.setDescription(request.getParameter("description"));
        orders.set(index, new Order(
                leEntry.getId(),
                leEntry.getItem(),
                leEntry.getCustomerName(),
                leEntry.getStatus(),
                leEntry.getCreated()
        ));
        getServletContext().setAttribute("orders", orders);

        response.sendRedirect("orders");

    }
}
