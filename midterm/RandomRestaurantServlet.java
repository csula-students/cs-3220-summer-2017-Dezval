package midterm;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random"})

public class RandomRestaurantServlet extends HttpServlet {

    Restaurant tempRestaurant;

    public void init(){
//        List<Restaurant> entries = new ArrayList<>();
//        entries.add(new Restaurant(entries.size(), "Apple pie", "description TBA"));
//        entries.add(new Restaurant(entries.size(), "Pumpkin Pie", "description TBA"));
//        getServletContext().setAttribute("entries", entries);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute("entries");
        getServletContext().setAttribute("entries", entries);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        tempRestaurant = getRandomRestaurant(entries);

        String radioFormDesignRating =
                "<p>Design</p>" +
                "<form method=\"post\">" +
                "<input name=\"designRate\" id=\"design_rate_1\" type=\"radio\" value=\"1\" checked>" +
                "<label for=\"design_rate_1\">1</label>" +
                "<br>" +
                "<input name=\"designRate\" id=\"design_rate_2\" type=\"radio\" value=\"2\">" +
                "<label for=\"design_rate_2\">2</label>" +
                "<br>" +
                "<input name=\"designRate\" id=\"design_rate_3\" type=\"radio\" value=\"3\">" +
                "<label for=\"design_rate_3\">3</label>" +
                "<br>" +
                "<input name=\"designRate\" id=\"design_rate_4\" type=\"radio\" value=\"4\">" +
                "<label for=\"design_rate_4\">4</label>" +
                "<br>" +
                "<input name=\"designRate\" id=\"design_rate_5\" type=\"radio\" value=\"5\">" +
                "<label for=\"design_rate_5\">5</label>" +
                "<br>" +
                "</form>";

        String radioFormTasteRating =
                "<p>Taste</p>" +
                "<form method=\"post\">" +
                "<input name=\"tasteRate\" id=\"taste_rate_1\" type=\"radio\" value=\"1\" checked>" +
                "<label for=\"taste_rate_1\">1</label>" +
                "<br>" +
                "<input name=\"tasteRate\" id=\"taste_rate_2\" type=\"radio\" value=\"2\">" +
                "<label for=\"taste_rate_2\">2</label>" +
                "<br>" +
                "<input name=\"tasteRate\" id=\"taste_rate_3\" type=\"radio\" value=\"3\">" +
                "<label for=\"taste_rate_3\">3</label>" +
                "<br>" +
                "<input name=\"tasteRate\" id=\"taste_rate_4\" type=\"radio\" value=\"4\">" +
                "<label for=\"taste_rate_4\">4</label>" +
                "<br>" +
                "<input name=\"tasteRate\" id=\"taste_rate_5\" type=\"radio\" value=\"5\">" +
                "<label for=\"taste_rate_5\">5</label>" +
                "<br>" +
                "<button>Submit Rating</button>" +
                "</form>";

        String tableWithRadioForms =
                "<table align=\"center\" cellpadding=\"15\">" +
                        "<td>" + radioFormDesignRating + "</td>" +
                        "<td>" + radioFormTasteRating + "</td>" +
                "</table>";


        out.println("<head>");
        out.println("<style>body, table, tr, td { " +
                "text-align:center;"+
                "}"+
                ""+
                "</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>What's for Lunch?</h1>");
        out.println("<br>");

        out.println("<table align=\"center\" cellpadding=\"5\" border=\"1px solid black\">");
            out.println(
                    "<tr>" +
                        "<td>You should go to:</td>" +
                        "<td rowspan=\"2\">" + tableWithRadioForms + "</td>" +
                    "</tr>"+
                    "<tr>" +
                        "<td><img src=\"https://raw.githubusercontent.com/csula/cs3220-summer-2017/master/notes/imgs/restaurant-placeholder.png\"></td>" +
//                        "<td>" + tempRestaurant.getURL() + "</td>" +
                    "</tr>"+
                    "<tr>" +
                        "<td><a href=\"" + tempRestaurant.getURL() +"\">" + tempRestaurant.getName() + "</a></td>" +
                        "<td>Submit Rating</td>" +
                    "</tr>"+
                    "<tr>" +
                        "<td>Feeling Lucky</td>" +
                        "<td><a href=\"random/list\">See Restaurant List</a></td>" +
                    "</tr>");
        out.println("</table>");


        out.println("</body>");
//        out.println("<a href='admin/foods'>Admin Page View</a>");
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute("entries");
//        entries.get(tempRestaurant.getId()).addDesignRating(Integer.valueOf(request.getParameter("designRate")));
//        entries.get(tempRestaurant.getId()).addTasteRating(Integer.valueOf(request.getParameter("tasteRate")));
////        getServletContext().setAttribute("entries", entries);
//
//        response.sendRedirect("../../admin/foods");
//    }

    public Restaurant getRandomRestaurant(List<Restaurant> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
