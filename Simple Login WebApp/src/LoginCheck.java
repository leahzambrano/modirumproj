

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		String logfile = "D:\\1.txt";
		String inputusername=request.getParameter("username");
		String inputpassword=request.getParameter("password");
		PrintWriter out = response.getWriter();
		

		if (inputusername.isEmpty() || inputpassword.isEmpty())
		{
			out.println("<html><h1><body text='red'>Cannot be blank!</body></h1></html>");
		} else {

			try {

				Scanner fileScan = new Scanner(new File(logfile));
				boolean found = false;
				while (fileScan.hasNextLine()) {

					String line = fileScan.nextLine();
					String Username = line.substring(0, line.indexOf(','));
					String Password = line.substring(line.indexOf(',')+1, line.length());

					if (inputusername.equals(Username) && inputpassword.equals(Password)) {
						found = true; // added this to set found
						break;

					} // removed the else statement
				}

				if (found) {
					response.sendRedirect("landingpage.jsp");
				}

				else {
					out.println("<html><h1><body text='red'>Invalid Credentials!</body></h1></html>");

				}

				fileScan.close();
			} catch (Exception e) {
				System.out.println("Error");
			}

		}

	}

}
