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
 * Servlet implementation class WardInterface
 */
@WebServlet("/WardInterface")
public class WardInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WardInterface() {
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
		 ///Get City Id
		   String wardid="";
		   try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
		        Statement smt=cn.createStatement();
		        ResultSet rs=smt.executeQuery("Select * from autogen");
		      if(rs.next())
		      {
		    	  wardid=rs.getString(2);
		      }
		      rs.close();


		   out.println("<html>");
		   out.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");

		   out.println("<script src=ward.js></script>");
		   out.println("<body style=color:#fff;background-image:url('bootstrap/img/morning_full.jpg');>");

		   out.println("<head>");

	       out.println("<table border=0 align=center>");
		   out.println("<caption><h3><i>Wards Registration</i></h3></caption>");
		   out.println("<form action=WardSubmit name=myform onsubmit=\"return call();\">");

		   out.println("<tr><td><b><i>City ID:</i></b></td><td><select name=cid>");
		   rs=smt.executeQuery("Select * from city");
		   while(rs.next())
		   {out.println("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");

		   }
		   rs.close();

		   out.println("</td><td>&nbsp;</td></tr>");
		   out.println("<tr><td><b><i>Ward ID:</i></b></td><td><input type=text name=wid id=wid value="+wardid+"></td><td><span id=mwid></span></td></tr>");

		   out.println("<tr><td><b><i>Ward Name:</i></b></td><td><input type=text name=wn id=wn></td><td><span id=mwn></span></td></tr>");
		   out.println("<tr><td><input type=submit value=Submit></td><td><input type=Reset value=Clear></td></tr>");

		   out.println("</table></form></head></body></html>");
		   out.flush();
		   }catch(Exception e){}

	}

}
