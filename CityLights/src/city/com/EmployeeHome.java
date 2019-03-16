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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeHome
 */
@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession(false);
		String eid="";
		
		String cdt="";
	try{
		eid=ses.getValue("seid").toString();
        cdt=ses.getValue("ldate").toString();
		String nav="<h4><font color=red>Employee Id:"+eid+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login Time:"+cdt+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=EmployeeLogout>Logout</a></h3><hr color=green>";
out.println(nav);
		}
		catch(Exception e)
		{
	    response.sendRedirect("Employeelogin");
		}

		 
try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
				PreparedStatement smt=cn.prepareStatement("select e.employeename,e.contact,e.designation,(select cityname from city where cityid=a.cityid),(select wardname from ward where wardid=a.wardid),a.wardid from allotment a, employees e where a.employeeid=e.employeeid and e.employeeid='"+eid+"'");
				  
	   ResultSet rs=smt.executeQuery();
	   
	   
		   out.println("HELLO");
		   out.println("<html>");
		 out.println("<body>");
		 out.println("<center><table border=1 align=center>");
		 out.println("<caption><b><i><font size=8>Your Information</font></i></b></caption>");


		if(rs.next())
	   {  out.println("<tr><td>Employee Name:s/td><td>"+rs.getString(2)+"</td><td>Contact No:</td><td>"+rs.getString(9)+"</td><tr><td>Designation:</td><td>"+rs.getString(11)+"</td><td>City:</td><td>"+rs.getString(8)+"</td></tr></table>");
		   out.println("<table border=1>");
		   out.println("<caption>List Of Wards</caption>");
		   out.println("<tr><th>Ward Id</th><th>Ward Name</th></tr>");
	   do{
			String wid=rs.getString(1);
		   out.println("<tr><td>"+wid+"</td><td><a href='ShowArea?wid="+wid+"'>"+rs.getString(3)+"</a></td></tr>");
	   }while(rs.next());
	   }
	   out.println("</table></center></body></html>");
	   
		 }
	catch(Exception e)
	{
		//response.sendRedirect("Employeelogin");
	}

	}

}
