package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserDto;

/**
 * Servlet implementation class boardWriteAction
 */
@WebServlet("/boardWriteAction")
public class boardWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boardWriteAction() {
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
		BoardDao dao = BoardDao.getInstance();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		UserDao userDao = UserDao.getInstance();
		UserDto userDto = userDao.getUserById(id);
		String password = userDto.getPassword();
		
		if (id != null && userDto != null && title != null && content != null) {
			BoardDto board = new BoardDto(title, content, id, password);
			dao.createBoard(board);
			System.out.println("추가성공");
			response.sendRedirect("board");
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
