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
 * Servlet implementation class EmployeeInterface
 */
@WebServlet("/EmployeeInterface")
public class EmployeeInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 PrintWriter out=response.getWriter();
	//////Session///
	  out.println("<html>");
	    String aid="";
		String cdt="";
		HttpSession ses=request.getSession(false);
		try{
		aid=ses.getValue("said").toString();
      cdt=ses.getValue("ldate").toString();
		String nav="<h4><font color=red>Employee Id:"+aid+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login Time:"+cdt+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></h3><hr color=green>";

		}
		catch(Exception e)
		{
	    response.sendRedirect("AdminLogin");
		}
		


	 //////
		out.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");
		out.println("<link href=\"bootstrap/css/datepicker.css\" rel=\"stylesheet\">");
		out.println("<link href=\"bootstrap/css/chosen.min.css\" rel=\"stylesheet\">");
		out.println("<link href=\"bootstrap/css/validcss.css\" rel=\"stylesheet\">");
		out.println("<link href=\"bootstrap/css/nprogress.css\" rel=\"stylesheet\">");
		out.println("<script src=bootstrap/js/jquery-v-1.9.1.js></script>");
		out.println("<script src=bootstrap/js/jquery.validate.min.js></script>");
		out.println("<script src=bootstrap/js/bootstrap-datepicker.js></script>");
		out.println("<script src=bootstrap/js/chosen.jquery.min.js></script>");
		out.println("<script src=bootstrap/js/nprogress.js></script>");

	 out.println("<script src=project.js></script>");
	 out.println("<script src=empjs.js></script>");
	 out.println("<html>");
     out.println("<form action=EmployeeSubmit method=post id=myform name=myform>");
	 out.println("<body onload=fillcountry();>");
     out.println("<table>");
	 out.println("<tr><td><b><i>Employee ID:</i></b></td><td><input type=text name=eid></td></tr>");
	 out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input type=text name=en></td></tr>");
	 out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=text class='dob' name=dob></td></tr>");
	 out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=gender value=Male>Male</td><td><input type=radio name=gender value=Female>Female</td></tr>");
	 out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=3 cols=25 name=address></textarea></td></tr>");
	 out.println("<tr><td><b><i>Country:</i></b></td><td><select name=country id=cnt onchange=fillstate();><option value='-Select-'>-Select-</option><option value='India'>India</option><option value='Pakistan'>Pakistan</option><option value='China'>China</option><option value='Srilanka'>Srilanka</option></select></td></tr>");
	 out.println("<tr><td><b><i>State:</i></b></td><td><select name=state id=st onchange=fillcity();></select></td></tr>");
	 out.println("<tr><td><b><i>City:</i></b></td><td><select name=city id=ct></select></td></tr>");
	 out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=contact></td></tr>");
	 out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=mailid></td></tr>");
	 out.println("<tr><td><b><i>Designation:</i></b></td><td><input type=text name=des></td></tr>");
	 out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password id=pwd name=pwd></td></tr>");
	 out.println("<tr><td><b><i>Confirm Password:</i></b></td><td><input type=password name=cpwd></td></tr>");
	 out.println("<tr><td><b><i>Picture:</i></b></td><td><input type=file name=picture></td></tr>");
	 out.println("<tr><td><input type=submit value=Submit></td><td><input type=reset Value=Clear></td></tr>");
	 out.println("</table></body></form></html>");
	 out.flush();
	}

}
