package city.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
	   out.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");
//////////////
		out.println("<div class=\"navbar\">");
		out.println("<div class=\"navbar-inner\">");
		out.println("<a class=\"brand\" href=\"#\">Citylight</a>");
		out.println("</div>");
		out.println("</div>");

		////////////

	  out.println("<div class=\"container\"><div class='row'>");
	  out.println("<div class='span6'>");
	  out.println("<img src=bootstrap/img/morning_full.jpg>");
	  out.println("</div>");

	  out.println("<div class='span4'>");


	  out.println("<table class='table table-bordered'>");
	   out.println("<caption><h3><i>Administrator Login</i></h3></caption>");
	   out.println("<form action=AdminLoginCheck method=post>");
	   out.println("<tr><td><div class=\"input-append\"><span class=\"add-on\"><i class='icon-user'></i></span><input type=text name=aid id=aid class=\"form-control\"> </div></td><td><span id=maid></span></td></tr>");
	   out.println("<tr><td><div class=\"input-append\"><span class=\"add-on\"><i class='icon-lock'></i></span><input type=password name=pwd id=pwd class=\"form-control\"> </div><td><span id=mpwd></span></td></td></tr>");
	   out.println("<tr><td><input type=submit value=Login class='btn btn-primary'></td><td>&nbsp;</td></tr>");
	   out.println("</table></form></html>");


	  out.println("</div>");

	  out.println("</div>");
	  out.println("</div>");

	   out.flush();

	}

}
