package city.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminInterface
 */
@WebServlet("/AdminInterface")
public class AdminInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   out.println("<script src=\"admin.js\"></script>");
	   out.println("<html>");

	   out.println("<table>");
	   out.println("<caption><h3><i>Administrator Registration</i></h3></caption>");
	   out.println("<form action=AdminSubmit method=post onsubmit=\"return chkSubmit();\">");
	   out.println("<tr><td><b><i>Admin ID:</i></b></td><td><input type=text name=aid id=aid></td><td><span id=maid></span></td></tr>");
	   out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text name=an id=an></td><td><span id=man></span></td></tr>");
	   out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=ac id=ac></td><td><span id=mac></span></td></tr>");
	   out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=ae id=ae></td><td><span id=mae></span></td></tr>");
	   out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password name=pwd id=pwd><td><span id=mpwd></span></td></td></tr>");
	   out.println("<tr><td><input type=submit value=Submit></td><td><input type=Reset value=Clear></td></tr>");
	   out.println("</table></form></html>");
	   out.flush();
	}

}
