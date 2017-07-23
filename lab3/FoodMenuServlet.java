package lab3;



import homework2.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@WebServlet(loadOnStartup=1, urlPatterns={"/menu"})

public class FoodMenuServlet extends HttpServlet {

//    public void init(){
//        List<FoodEntry> entries = new ArrayList<>();
//        entries.add(new FoodEntry(entries.size(), "Apple pie", 11.99, "description"));
//        entries.add(new FoodEntry(entries.size(), "Pumpkin Pie", 11.99, "description"));
//        getServletContext().setAttribute("entries", entries);
//    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        out.println("<h1>Food Menu</h1>");

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
                            "<td><button><a href='addToCart?id=" + entry.getId() + "'>Add To Cart</a></button></td>" +
//                            "<td><a href='foods/edit?id=" + entry.getId() + "'>Edit</a></td>" +
//                            "<td><a href='foods/delete?id=" + entry.getId()+ "'>Delete</a></td>" +
                            "</tr>");
        }
        out.print("</table>");
//        out.println("<a href='admin/foods'>Admin Page View</a>");
        out.println("<br>");
        out.println("<button><a href='shopping-cart'>View Cart</a></button>");

    }


}

