package staffAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStaffServlet")
public class deleteStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empID = request.getParameter("empID");
		
		boolean isTrue;
		
		isTrue = staffDBUtil.deleteStaff(empID);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("editStaff.jsp"); 
			dispatcher.forward(request, response); 
		}
		else {
			List<staff> staffDetails = staffDBUtil.getStaffDetails(empID);
			request.setAttribute("staffDetails", staffDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteStaff.jsp");
			dispatcher.forward(request, response); 
		}
	}
}