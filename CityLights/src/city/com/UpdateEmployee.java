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

		/**
		 * Servlet implementation class EmployeeInterface
		 */
		@WebServlet("/UpdateEmployee")
		public class UpdateEmployee extends HttpServlet {
			private static final long serialVersionUID = 1L;

		    /**
		     * @see HttpServlet#HttpServlet()
		     */
		    public UpdateEmployee() {
		        super();
		        // TODO Auto-generated constructor stub
		    }

			/**
			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
			 PrintWriter out=response.getWriter();
			 String eid=request.getParameter("eid");
			 try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/citylightss","root","abhijeet");
					PreparedStatement smt=cn.prepareStatement("select * from employees where employeeid=?");
				    smt.setString(1,eid);
		   ResultSet rs=smt.executeQuery();
		   if(rs.next())
		   {
				    out.println("<script src=project.js></script>");
		     out.println("<html>");
		     out.println("<form action=FinalEditDelete method=post name=myform>");
			 out.println("<body onload=fillcountry();>");
		     out.println("<table>");
			 out.println("<tr><td><b><i>Employee ID:</i></b></td><td><input type=text name=eid value="+rs.getString(1)+"></td></tr>");
			 out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input type=text name=en value="+rs.getString(2)+"></td></tr>");
			 out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=text name=dob value="+rs.getString(3)+"></td></tr>");
			 if(rs.getString(4).equals("Male"))
			 {
			 out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=gender value=Male checked>Male<input type=radio name=gender value=Female>Female</td></tr>");
			 }
			 else
			 {out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=gender value=Male checked>Male<input type=radio name=gender value=Female checked>Female</td></tr>");
			 }
			 out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=3 cols=25 name=address>"+rs.getString(5)+"</textarea></td></tr>");
			 out.println("<tr><td><b><i>Country:</i></b></td><td><select name=country id=cnt onchange=fillstate();><option>"+rs.getString(6)+"</option></select></td></tr>");

			 out.println("<tr><td><b><i>State:</i></b></td><td><select name=state id=st onchange=fillcity();><option>"+rs.getString(7)+"</option></select></td></tr>");
			 out.println("<tr><td><b><i>City:</i></b></td><td><select name=city id=ct><option>"+rs.getString(8)+"</option></select></td></tr>");
			 out.println("<tr><td><b><i>Contact No:</i></b></td><td><input type=text name=contact value="+rs.getString(9)+"></td></tr>");
			 out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=text name=mailid value="+rs.getString(10)+"></td></tr>");
			 out.println("<tr><td><b><i>Designation:</i></b></td><td><input type=text name=des value="+rs.getString(11)+"></td></tr>");
			 out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password name=pwd></td></tr>");
			 out.println("<tr><td><b><i>Confirm Password:</i></b></td><td><input type=password name=cpwd></td></tr>");
			 out.println("<tr><td><b><i>Picture:</i></b></td><td><input type=file name=picture><img src=players/"+rs.getString(13)+" width=35 height=35></td></tr>");
			 out.println("<tr><td><input type=submit value=Edit name=btn></td><td><input type=Submit Value=Delete name=btn></td></tr>");
			 out.println("</table></body></form></html>");
			 out.flush();
		   }
		   }catch(Exception e)
		   {out.println(e);
			   }
		   }







	}


