package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ModifyAction
 */
@WebServlet("/ModifyAction")
public class ModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = UserDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		UserDto user = null;
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		user = userDao.getUserById(id);

		//비밀번호 이름  폰 

		String password = request.getParameter("password");
		if(password != null)
			user.setPassword(password);

		String name = request.getParameter("name");
		if(name != null)
			user.setName(name);

		String nickname = request.getParameter("nickname");
		if(nickname != null)
		user.setNickname(nickname);

		String phone = request.getParameter("phone");
		if(phone != null)
		user.setPhone(phone);

		String email = request.getParameter("email");
		if(phone != null)
			user.setEmail(email);

		userDao.modifyUser(user, no);
		response.sendRedirect("mypage");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
