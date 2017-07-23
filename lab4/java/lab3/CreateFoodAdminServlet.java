package lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Add a Dish!</h1>");

        out.println("<form method =\"post\">");
        out.println("Dish name: <input name='name' type='text' /></br>");
        out.println("Price $: <input name='price' type='number' step='.01' /></br>");
        out.println("<textarea name='description'></textarea></br>");
        out.println("<button>Add</button>");
        out.println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FoodEntry> entries = (List<FoodEntry>) getServletContext().getAttribute("entries");
        entries.add(new FoodEntry(entries.size(), request.getParameter("name"), Double.valueOf(request.getParameter("price")), request.getParameter("description")));
        getServletContext().setAttribute("entries", entries);

        response.sendRedirect("../../admin/foods");
    }
}