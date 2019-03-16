package city.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		   PrintWriter out=response.getWriter();
		    out.println("<html>");
		   out.println("<div class='row'>");
		   out.println("<div class='span4'>");
		   out.println("<ul class=\"nav nav-tabs nav-stacked\">");
			out.println("<li class=\"active\"><a href=EmployeeInterface target=mw>Employee Register</a></li>");
			out.println("<li><a href=ListEmployee target=mw>List Of Employee</a></li>");
			out.println("<li><a href=CityInterface target=mw>City Register</a></li>");
			out.println("<li><a href=WardInterface target=mw>Wards Register</a></li>");
			out.println("<li><a href=AreaInterface target=mw>Area Register</a></li>");
			out.println("<li><a href=AssignmentInterface target=mw>Ward Assignment</a></li>");
			out.println("<li><a href=AdminLogout target=_self>Logout</a></li>");
			out.println("</ul>");
		   out.println("</div><div class='span5'><iframe frameborder=0 width=700 height=700 name=mw></div></div></html>");







	}

}
