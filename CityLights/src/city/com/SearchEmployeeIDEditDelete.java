package city.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEmployeeIDEditDelete
 */
@WebServlet("/SearchEmployeeIDEditDelete")
public class SearchEmployeeIDEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployeeIDEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<form action=UpdateEmployee>");
	out.println("<table>");
	out.println("<tr><td>Employee Id:</td><td><input type=text name=eid></td><td><input type=submit value=Search></td></tr>");
	out.println("</table></form></html>");
	out.flush();
	 }

}
