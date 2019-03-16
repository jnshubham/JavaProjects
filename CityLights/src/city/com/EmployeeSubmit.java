package city.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
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
			String eid=request.getParameter("eid");
			String en=request.getParameter("en");
			String dob=request.getParameter("dob");
			String gender=request.getParameter("gender");
			String address=request.getParameter("address");
			String state=request.getParameter("state");
			String city=request.getParameter("city");
			String contact=request.getParameter("contact");
			String mailid=request.getParameter("mailid");
			String des=request.getParameter("des");
			String pwd=request.getParameter("pwd");

			String picture=request.getParameter("picture");
			picture=picture.substring(picture.lastIndexOf("\\")+1);
			String country=request.getParameter("country");



			PreparedStatement smt=cn.prepareStatement("Insert into employees values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			smt.setString(1,eid);
			smt.setString(2,en);
			smt.setString(3,dob);

			smt.setString(4,gender);
			smt.setString(5,address);

			smt.setString(6,country);
			smt.setString(7,state);
			smt.setString(8,city);
			smt.setString(9,contact);
			smt.setString(10,mailid);
			smt.setString(11,des);
			smt.setString(12,pwd);
			smt.setString(13,picture);
			smt.execute();
			out.println("Record Submitted....");
			cn.close();

		}catch(Exception e){
			out.println(e);

		}


	}

}
