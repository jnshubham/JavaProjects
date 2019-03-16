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
 * Servlet implementation class ShowArea
 */
@WebServlet("/ShowArea")
public class ShowArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArea() {
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
			 String wid=request.getParameter("wid");
				PreparedStatement smt=cn.prepareStatement("select * from area where wardid=?");
			     smt.setString(1,wid);
	   ResultSet rs=smt.executeQuery();
	   if(rs.next())
	   { out.println("<script src=project.js></script>");
		   out.println("<html><table border=1>");
	   out.println("<caption><i>List of Area</i></caption>");
	   
	   out.println("<tr><th>Area ID</th><th>Area Name</th><th>On/Off</th></tr>");
	   do{
		   String key=rs.getString(4);
	   out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><img src=players/OFF.png id=status onclick=onoff('"+key+"');"+"></td>");
	   }while(rs.next());
		   out.println("</table></html>");
	   }
	   else
	   {out.println("No Area Found in this Ward");

	   }
		 }catch(Exception e)
	  {out.println(e);
		  }

	}

}
