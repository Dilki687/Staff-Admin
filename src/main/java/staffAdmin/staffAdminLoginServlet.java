package staffAdmin;

import java.io.IOException;
//import java.util.List;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/staffAdminLoginServlet")
public class staffAdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    // calling validate function to validate username and password
	    Boolean isTrue = staffDBUtil.validateAdmin(username, password);

	    if (isTrue) {
	        // If validation is successful, create session
	        HttpSession session = request.getSession();
	        session.setAttribute("adminUsername", username);
	        RequestDispatcher dis = request.getRequestDispatcher("adminHome.jsp");
	        dis.forward(request, response);
	    } else {
	        // If validation is unsuccessful, display alert
	        PrintWriter out = response.getWriter();
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Incorrect username or password');");
	        out.println("location='adminLogin.jsp'");
	        out.println("</script>");
	    }
	}
}
