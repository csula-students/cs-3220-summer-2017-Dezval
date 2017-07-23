 package edu.csula;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.util.List;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 @WebServlet("/guestbook/create")
 public class CreateGuestBookServlet extends HttpServlet {
 	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html");
 		PrintWriter out = response.getWriter();
 		out.println("<h1>Hello world!</h1>");

         out.println("<form method =\"post\">");
         out.println("Your name: <input name='name' type='text' /></br>");
         out.println("<textarea name='comment'></textarea></br>");
         out.println("<button>Add</button>");
         out.println("</form>");
        
 	}

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
         entries.add(new GuestBookEntry(entries.size(), request.getParameter("name"), request.getParameter("comment")));
         getServletContext().setAttribute("entries", entries);
         PrintWriter out = response.getWriter();
         out.println("<a href='/guestbook'>go back to guest book</a>");
     }
 }
