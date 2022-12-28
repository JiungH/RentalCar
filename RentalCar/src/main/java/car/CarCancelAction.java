package car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarCancelAction
 */
@WebServlet("/CarCancelAction")
public class CarCancelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarCancelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		CarDao carDao = CarDao.getInstance();
		CarDto carDto = carDao.getCarByNo(no);
		carDto.setUser(null);
		carDto.setRentTime(null);
		carDto.setReturnTime(null);
		carDto.setCheck(false);
		carDao.bookingCar(carDto);
		response.sendRedirect("myReservation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
