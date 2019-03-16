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

/**
 * Servlet implementation class GetWardByCityID
 */
@WebServlet("/GetWardByCityID")
public class GetWardByCityID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWardByCityID() {
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
	        Statement smt=cn.createStatement();
	        String cid=request.getParameter("cid");
	        ResultSet rs=smt.executeQuery("Select * from ward where cityid='"+cid+"'");
		    String ward="";
	        while(rs.next())
	        {
	        	ward=ward+rs.getString(1)+":"+rs.getString(3)+",";

	        }
		  out.println(ward);
		}catch(Exception e)
		{
		out.println(e);
		}
	}

}
