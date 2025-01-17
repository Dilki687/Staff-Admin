package staffAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaystaffServlet")
public class displaystaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<staff> staffDetails=staffDBUtil.getStaffInfo();
		request.setAttribute("staffDetails", staffDetails);
		RequestDispatcher dis=request.getRequestDispatcher("editStaff.jsp");
		dis.forward(request, response);
	}
}
