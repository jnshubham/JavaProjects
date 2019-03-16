package city.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AssignmentInterface
 */
@WebServlet("/AssignmentInterface")
public class AssignmentInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
			Statement smt=cn.createStatement();

				out.println("<script src=AjaxAssign.js></script><script src=ajax.js></script>" +
				"<html>" +
				"<caption><h2><b><i>Assigning Employees</i></b></caption>" +
				"<form action=AssignmentSubmit name=myform>" +
				"<table>" +
				"<tr><td><b><i>City ID:</i></b></td><td><select name=cid id=cid onchange=ajaxrequest();>");
				ResultSet rs=smt.executeQuery("Select * from city");
				while(rs.next())
				{
					out.println("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
				}
				rs.close();

				out.println("</td><td>&nbsp</td></tr>" +
				"<tr><td><b><i>Ward ID:</i></b></td><td><select name=wid id=wid></td><td><span id=mwid></span></td></tr>" +
				"<tr><td><b><i>Employee ID:</i></b></td><td><select name=eid id=eid onchange=getEmployee();>");
				rs=smt.executeQuery("select * from employees");
				while(rs.next())
				{String eid=rs.getString(1);
					out.println("<option value="+eid+">"+eid+"</option>");
				}



				out.println("</td><td>&nbsp;</td></tr></table>");

				out.println("<br><span id=meid></span><br><input type=submit value=Assign></form></html>");

		}
		catch(Exception e)
		{
			out.println(e);
		}

	}
}
