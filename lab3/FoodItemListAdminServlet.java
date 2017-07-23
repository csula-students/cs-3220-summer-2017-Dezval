package lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// TODO add two decimal places to the price double

@WebServlet(loadOnStartup=1, urlPatterns={"/admin/foods"})

public class FoodItemListAdminServlet extends HttpServlet {

    public void init(){
        List<FoodEntry> entries = new ArrayList<>();
        entries.add(new FoodEntry(entries.size(), "Apple pie", 11.99, "description TBA"));
        entries.add(new FoodEntry(entries.size(), "Pumpkin Pie", 11.99, "description TBA"));
        getServletContext().setAttribute("entries", entries);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        out.println("<h1>List of Foods</h1>");

        out.println("<head>");
        out.println("<style>body { " +
                "}</style>");
        out.println("</head>");

        out.println("<table>");
        for (FoodEntry entry: entries){
            out.println(
                    "<tr>" +
                            "<td>" + entry.getName() + "</td>" +
                            "<td>" + entry.getDescription() + "</td>" +
                            "<td>$" + entry.getPrice() + "</td>" +
                            "<td><a href='foods/edit?id=" + entry.getId() + "'>Edit</a></td>" +
                            "<td><a href='foods/delete?id=" + entry.getId()+ "'>Delete</a></td>" +
                            "</tr>");
        }
        out.print("</table>");
        out.println("<button><a href='../admin/foods/create'>Add Food Dish</a></button>");
//        out.println("<br>");
        out.println("<button><a href='../menu'>Menu View!</a></button>");
        out.println("<br>");
        out.println("<br>");
        out.println("<button><a href='orders'>View Orders</a></button>");
    }
}
