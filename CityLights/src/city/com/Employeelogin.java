package city.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employeelogin
 */
@WebServlet("/Employeelogin")
public class Employeelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employeelogin() {
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

	   out.println("<html>");
	 out.println("<body>");
	   out.println("<table align=center>");
	   out.println("<caption><h3><i><font size=8 color=black>Employee Login</font></i></h3></caption>");
	   out.println("<form action=Employeelogincheck >");
	   out.println("<tr><td><b><i><font size=5 color=black>Employee Id:</font></i></b></td><td><input type=text name=eid id=eid></td></tr>");
	   out.println("<tr><td><b><i><font size=5 color=black>Password:</font></i></b></td><td><input type=password name=pwd id=txt1></td></tr>");
	   out.println("<tr><td><input type=submit value=Login></td><td>&nbsp;</td></tr>");
	   out.println("</table></form></body></html>");
	   out.flush();



	}

}
