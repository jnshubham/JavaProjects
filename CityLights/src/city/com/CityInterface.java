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
 * Servlet implementation class CityInterface
 */
@WebServlet("/CityInterface")
public class CityInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityInterface() {
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
		   String cityid="";
		   try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
		        Statement smt=cn.createStatement();
		        ResultSet rs=smt.executeQuery("Select * from autogen");
		      if(rs.next())
		      {
		    	  cityid=rs.getString(1);
		      }
		      rs.close();
		   }catch(Exception e){}

		        out.println("<html>");
		        out.println("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\">");

		   out.println("<body>");
		   out.println("<table class='table'>");
		   out.println("<caption><h3><i>City Registration</i></h3></caption>");
		   out.println("<form action=CitySubmit >");

		   out.println("<tr><td><b><i>City ID:</i></b></td><td><input type=text name=cid id=cid value="+cityid+"></td></tr>");
		   out.println("<tr><td><b><i>City Name:</i></b></td><td><input type=text name=cin id=cin></td></tr>");
		   out.println("<tr><td><input type=submit value=Submit></td><td><input type=Reset value=Clear></td></tr>");
		   out.println("</table></form></body></html>");
		   out.flush();
	}


}
