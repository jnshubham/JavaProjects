package city.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListEmployee
 */
@WebServlet("/ListEmployee")
public class ListEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");

			PreparedStatement smt=cn.prepareStatement("select * from employees");
			ResultSet rs=smt.executeQuery();
			if(rs.next())
			{out.println("<html>");
			out.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");
			out.println("<script src=bootstrap/js/jquery-v-1.9.1.js></script>");
			out.println("<script src=bootstrap/js/jquery.dataTables.js></script>");
			out.println("<script >$(function(){$('.table').dataTable();    });</script>");

			out.println("<table class='table table-bordered table-hover'>");

			 out.println("<thead><tr class='table-header'>");
			 out.println("<th>Employee Id/Name</th><th>Birth Date</th><th>Address</th><th>Contacts</th><th>Designation</th><th>Update</th></tr></thead><tbody>");
			 do{
			out.println("<tr>");
			String eid=rs.getString(1);
			out.println("<td>"+eid+"/"+rs.getString(2)+"<br>["+rs.getString(4)+"]</td>");
			out.println("<td>"+rs.getDate(3)+"</td>");
			out.println("<td>"+rs.getString(5)+"<br>"+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+"</td>");
			out.println("<td>Mobile:"+rs.getString(9)+"<br>Email:"+rs.getString(10)+"</td>");
			out.println("<td><img src=players/"+rs.getString(13)+" width=65 height=65><br>["+rs.getString(11)+"]</td>");
			out.print("<td><a href=UpdateEmployee?eid="+eid+" class='btn'><i class=\"icon-edit\"></i>/<i class='icon-remove-sign'></i></a>");
			out.println("</tr>");

			 }while(rs.next());
			 out.println("</tbody></table></html>");


			}
			else
			{
			out.println("Record Not Found");
			}

		}
		catch(Exception e)
		{
		out.print(e);

		}
	}

}
