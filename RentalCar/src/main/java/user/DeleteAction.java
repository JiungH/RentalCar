package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/DeleteAction")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		UserDao userDao = UserDao.getInstance();
		UserDto user = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("id");
		System.out.println(user);
		if (id.equals(userid)) {
			user = userDao.getUserById(id);
			userDao.deleteUser(id);
			if (user != null) {
				String checkPassword = user.getPassword();
				if (password.equals(checkPassword)) {
					userDao.deleteUser(id);
					session.setAttribute("id", null);
					response.sendRedirect("home");
				} else {
					response.sendRedirect("home");
				}
			}else {
				response.sendRedirect("mypage");
			}
		}else {
			response.sendRedirect("mypage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

}
