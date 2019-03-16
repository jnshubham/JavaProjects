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
 * Servlet implementation class AreaSubmit
 */
@WebServlet("/AreaSubmit")
public class AreaSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaSubmit() {
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
			String wid=request.getParameter("wid");
			String areaid=request.getParameter("areaid");
			String areaname=request.getParameter("areaname");
			String areakey=request.getParameter("areakey");
			PreparedStatement smt=cn.prepareStatement("Insert into area values(?,?,?,?)");
			smt.setString(1,wid);
			smt.setString(2,areaid);
			smt.setString(3,areaname);
			smt.setString(4,areakey);
			smt.executeUpdate();
			out.println("Record Submitted....<br><a href=AreaInterface>Click Here To Add More Area...</a>");
			smt=cn.prepareStatement("update autogen set areaid=areaid+1");
			smt.executeUpdate();
			cn.close();

		}catch(Exception e){
			out.println(e);

		}



	}

}
