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
 * Servlet implementation class FinalEditDelete
 */
@WebServlet("/FinalEditDelete")
public class FinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDelete() {
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

			String btn=request.getParameter("btn");
			if(btn.equals("Edit"))
			{

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



			PreparedStatement smt=cn.prepareStatement("update employees set employeename=?,dob=?,gender=?,address=?,state=?,city=?,contact=?,mailid=?,designation=?,country=? where employeeid=?");

			smt.setString(1,en);
			smt.setString(2,dob);

			smt.setString(3,gender);
			smt.setString(4,address);

			smt.setString(5,state);
			smt.setString(6,city);
			smt.setString(7,contact);
			smt.setString(8,mailid);
			smt.setString(9,des);
			smt.setString(10,country);
			smt.setString(11,eid);
			 smt.execute();
			 if(!pwd.equals(""))
			 {
				 smt=cn.prepareStatement("update employees set password=?  where employeeid=?");

					smt.setString(1,pwd);
					smt.setString(2,eid);
					 smt.execute();
			 }

			 if(!picture.equals(""))
			 {
				 smt=cn.prepareStatement("update employees set picture=?  where employeeid=?");

					smt.setString(1,picture);
					smt.setString(2,eid);
					 smt.execute();
			 }


			}
			else
			{

				String eid=request.getParameter("eid");


				PreparedStatement smt=cn.prepareStatement("delete from employees   where employeeid=?");

				smt.setString(1,eid);
				 smt.execute();

			}
			response.sendRedirect("ListEmployee");

			cn.close();
		}catch(Exception e){
			out.println(e);

		}

	}

}
