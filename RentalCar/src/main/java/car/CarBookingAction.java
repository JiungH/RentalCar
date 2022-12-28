package car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarBookingAction
 */
@WebServlet("/CarBookingAction")
public class CarBookingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarBookingAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		CarDao carDao = CarDao.getInstance();
		CarDto carDto = carDao.getCarByNo(no);
		String sd = request.getParameter("sd");
		String ed = request.getParameter("ed");
		carDto.setUser(id);
		carDto.setRentTime(sd);
		carDto.setReturnTime(ed);
		carDto.setCheck(true);
		carDao.bookingCar(carDto);
		response.sendRedirect("myReservation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

}
