package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = UserDao.getInstance();
		UserDto userDto = null;
		/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");/*  */


		request.setCharacterEncoding("UTF-8");
		/* no id password name nickname gender phone resDate */
		int no =  Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");


		/* if(no != null && id != null && password != null && name != null && nickname != null && gender != null && phone != null && resDate != null){ */
			userDto = new UserDto(no, id , password, name , nickname , gender, phone,email);
			userDao.createUser(userDto);
			response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
