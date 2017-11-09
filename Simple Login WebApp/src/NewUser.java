
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		String logfile = "D:\\1.txt";
		PrintWriter out = response.getWriter();

		String inputusername = request.getParameter("username");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		if (inputusername.isEmpty() || password.isEmpty() || cpassword.isEmpty()) 
		{
			out.println("<html><h1><body text='red'>Cannot be blank!</body></h1></html>");
		} 
		else if (!password.equals(cpassword)) 
		{
			out.println("<html><h1><body text='red'>Password confirmation is incorrect!</body><h1></html>");
		}

		else
		{
				try {
				
					Scanner fileScan = new Scanner(new File(logfile));
					boolean found = false;
					while (fileScan.hasNextLine()) {

						String line = fileScan.nextLine();
						String username = line.substring(0, line.indexOf(','));
					

						if (inputusername.equals(username)) 
							{
							found = true; // added this to set found
							break;
							} 
					}

					if (found) 
					{
					out.println("<html><h1><body text='red'>Username already exists!</body></h1></html>");
					}

					else 
					{
					// Assume default encoding.
					FileWriter fileWriter = new FileWriter(logfile, true);

					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

					bufferedWriter.newLine();
					bufferedWriter.write(inputusername);
					bufferedWriter.write(",");
					bufferedWriter.write(password);

					out.println("<html><h1><body text='green'>User has been successfully added!</body></h1></html>");

					bufferedWriter.close();
					fileScan.close();
					} 
				}
				catch (IOException ex) {
					System.out.println("Error writing to file '" + logfile + "'");
				}
				
			
				
			
			catch (Exception e) {
				System.out.println("Error");
			}
	
		}
	}
}

				
				
				
				