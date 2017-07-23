package lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/foods/edit")
public class EditFoodAdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        FoodEntry leEntry = null;
        for(FoodEntry entry: entries){
            if(entry.getId() == id){
                leEntry = entry;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Edit Description</h1>");
        out.println("<form method =\"post\">");
        out.println("Food Entry name: <input name='name' type='text' value='" + leEntry.getName() + "'/></br>");
        out.println("Price $: <input name='price' type='number' value='"+ leEntry.getPrice() + "' /></br>");
        out.println("<textarea name='description'>" + leEntry.getDescription() + "</textarea></br>");
        out.println("<button>Edit</button>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        FoodEntry leEntry = null;
        int index = -1;
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getId() == id){
                leEntry = entries.get(i);
                index = i;
            }
        }
        entries.set(index, new FoodEntry(
                leEntry.getId(),
                request.getParameter("name"),
                Double.valueOf(request.getParameter("price")),
                request.getParameter("description")

        ));
        getServletContext().setAttribute("entries", entries);

        response.sendRedirect("../../admin/foods");

    }
}
