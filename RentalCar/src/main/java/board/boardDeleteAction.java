package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class boardDeleteAction
 */
@WebServlet("/boardDeleteAction")
public class boardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDao dao = BoardDao.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(request.getParameter("no") != null) {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDto dto = dao.getBoardByNo(no);
			if(id.equals(dto.getUser())) {
				dao.deleteBoard(no);
				response.sendRedirect("board");
			}else {
				response.sendRedirect("home");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
