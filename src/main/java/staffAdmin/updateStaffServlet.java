package staffAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStaffServlet")
public class updateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empID = request.getParameter("empID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String post = request.getParameter("post");
		String phoneNumber = request.getParameter("phoneNumber");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		boolean isTrue;
		
		isTrue = staffDBUtil.updateStaff(empID, username, password, post, phoneNumber, gender, email);
		
		if(isTrue == true) {
			List<staff> staffDetails = staffDBUtil.getStaffDetails(empID);
			request.setAttribute("staffDetails", staffDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("editStaff.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("updateStaff.jsp");
			dis.forward(request, response);
		}
	}
}
