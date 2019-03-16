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
 * Servlet implementation class AreaInterface
 */
@WebServlet("/AreaInterface")
public class AreaInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaInterface() {
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
		   out.println("<script src=ajax.js></script>");
		   out.println("<body style=background-image:url('5.jpg');>");
		   out.println("<table align=center>");
		   out.println("<caption><h3><i><font size=8>Area Registration</font></i></h3></caption>");
		   out.println("<form action=AreaSubmit name=myform>");
		   try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
		        Statement smt=cn.createStatement();
		        ResultSet rs=smt.executeQuery("Select * from autogen");
		     String areaid="";
		        if(rs.next())
		      {
		    	  areaid=rs.getString(3);
		      }
              rs.close();
              out.println("<tr><td><b><i><font size=5>City ID:</font></i></b></td><td><select name=cid id=cid onchange=ajaxrequest();>");
   		   rs=smt.executeQuery("Select * from city");
   		   while(rs.next())
   		   {out.println("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");

   		   }
   		   rs.close();

   		   out.println("</td><td>&nbsp;</td></tr>");
   		   out.println("<tr><td><b><i><font size=5>Ward ID:</font></i></b></td><td><select name=wid id=wid></select></td><td>&nbsp;</td></tr>");

   		   out.println("<tr><td><b><i><font size=5>Area ID:</font></i></b></td><td><input type=text name=areaid id=areaid value="+areaid+"></td><td><span id=mareaid></span></td></tr>");
		   out.println("<tr><td><b><i><font size=5>Area Name:</font></i></b></td><td><input type=text name=areaname id=areaname></td><td><span id=mareaname></span></td></tr>");
		   out.println("<tr><td><b><i><font size=5>Area Key:</font></i></b></td><td><input type=text name=areakey id=areakey></td><td><span id=mareakey></span></td></tr>");
		   out.println("<tr><td><input type=submit value=Submit></td><td><input type=Reset value=Clear></td></tr>");
		   out.println("</table></form></body></html>");
		   out.flush();
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	}
		}
