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
 * Servlet implementation class Employeelogincheck
 */
@WebServlet("/Employeelogincheck")
public class Employeelogincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employeelogincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
			String eid=request.getParameter("eid");
			String pwd=request.getParameter("pwd");
			PreparedStatement smt=cn.prepareStatement("select * from employees where employeeid=? and password=?");
		    smt.setString(1,eid);
		    smt.setString(2,pwd);
		    ResultSet rs=smt.executeQuery();

		    if(rs.next())
		    {HttpSession ses=request.getSession();
		     ses.putValue("seid",eid);
		     ses.putValue("ldate",new java.util.Date());

		    	response.sendRedirect("EmployeeHome");

		    	}
		    else
		    {
		    out.println("Invalid AdminId/Password....");

		    }

		    cn.close();
		}
		   catch(Exception e)
		{
			out.println(e);
		}
	out.flush();









	}

}
