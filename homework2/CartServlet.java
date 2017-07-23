package homework2;

import com.sun.org.apache.xpath.internal.operations.Or;
import lab3.FoodEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(loadOnStartup=1, urlPatterns={"/shopping-cart"})

public class CartServlet extends HttpServlet {

    public void init(){
        List<Order> orders = new ArrayList<>();
//        orders.add(new FoodEntry(orders.size(), "Apple pie", 11.99, "description"));
//        orders.add(new FoodEntry(orders.size(), "Pumpkin Pie", 11.99, "description"));
        getServletContext().setAttribute("orders", orders);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
        out.println("<h1>List of Orders</h1>");

        out.println("<head>");
        out.println("<style>body { " +
                "}</style>");
        out.println("</head>");

        out.println("<table>");
        for (Order order: orders){
            out.println(
                    "<tr>" +
                            "<td>" + order.getItem().getName() + "</td>" +
                            "<td>" + order.getPrice() + "</td>" +
                            "<td>" + order.getStatus() + "</td>" +
//                            "<td>$" + order.getPrice() + "</td>" +
//                            "<td><a href='foods/edit?id=" + entry.getId() + "'>Edit</a></td>" +
//                            "<td><a href='foods/delete?id=" + entry.getId()+ "'>Delete</a></td>" +
                            "</tr>");
        }
        out.print("</table>");
//        out.println("<a href='admin/foods'>Admin Page View</a>");
        out.println("<br>");
        out.println("<button><a href='menu'>Return To Food Menu</a></button>");
    }
}
