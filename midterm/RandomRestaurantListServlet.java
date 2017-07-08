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

@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random/list"})

public class RandomRestaurantListServlet extends HttpServlet {

    public void init(){
        List<Restaurant> entries = new ArrayList<>();
        addRestaurantsToList(entries);
//        entries.add(new Restaurant(entries.size(), "Apple Restaurant", "URL"));
//        entries.add(new Restaurant(entries.size(), "Pumpkin Restaurant", "URL"));
        getServletContext().setAttribute("entries", entries);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute("entries");
        out.println("<h1>List of Restaurants</h1>");

        out.println("<head>");
        out.println("<style>body, table, tr, td { " +
                "text-align:center;"+
                "}"+
                ""+
                "</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table align=\"center\" cellpadding=\"5\" border=\"1px solid black\"> + " +
                "<tr>" +
                "<td>Restaurant Name</td>" +
                "<td>Restaurant Site</td>" +
                "<td>Design Rating</td>" +
                "<td>Taste Rating</td>" +
                "</tr>");


        for (Restaurant entry: entries){
            out.println(
                    "<tr>" +
                            "<td>" + entry.getName() + "</td>" +
                            "<td><a href=\"" + entry.getURL() + "\">Restaurant #"+ entry.getId() +"</a></td>" +
                            "<td>" + entry.getDesignRating() + "</td>" +
                            "<td>" + entry.getTasteRating() + "</td>" +
                            "</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("<h2><a href='/suggest/restaurants/random'>Random Restaurant</a></h2>");
    }

    private void addRestaurantsToList(List<Restaurant> list){
        for(int i = 0; i < 23; i++){
            list.add(new Restaurant(i, "Restaurant " + i, "A Fellow Restaurant"));
            if(i < 10){
                list.get(i).URL = "http://cs3.calstatela.edu:8080/cs3220xstu0"+i+"/menu";
            }else{
                list.get(i).URL = "http://cs3.calstatela.edu:8080/cs3220xstu"+i+"/menu";
            }
        }
    }

    // TODO Center the html table above
    // TODO Give padding and borders to the html table above
}
