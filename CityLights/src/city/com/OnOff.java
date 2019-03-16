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
 * Servlet implementation class OnOff
 */
@WebServlet("/OnOff")
public class OnOff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static CommLight L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnOff() {
        super();
       L=new CommLight("COM3");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try
		{
          String key=request.getParameter("key");


		L.sendMessage(key);


          out.println("status:"+key);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	// TODO Auto-generated method stub
	}

}
