package city.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AdminSubmit
 */
@WebServlet("/AdminSubmit")
public class AdminSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
		String aid=request.getParameter("aid");
		String an=request.getParameter("an");
		String ac=request.getParameter("ac");
		String ae=request.getParameter("ae");
		String pwd=request.getParameter("pwd");
		PreparedStatement smt=cn.prepareStatement("Insert into admin values(?,?,?,?,?)");
		smt.setString(1,aid);
		smt.setString(2,an);
		smt.setString(3,ac);
		smt.setString(4,ae);
		smt.setString(5,pwd);
		smt.execute();
		out.println("Record Submitted....");
		cn.close();

	}catch(Exception e){
		out.println(e);

	}

	}

}
