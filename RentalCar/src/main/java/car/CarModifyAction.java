package car;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarModifyAction
 */
@WebServlet("/CarModifyAction")
public class CarModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		CarDao carDao = CarDao.getInstance();		
		CarDto carDto = null;
		
		int no = Integer.parseInt(request.getParameter("no"));
		carDto = carDao.getCarByNo(no);
		
		String color = request.getParameter("color");
		if(color != null)
		carDto.setColor(color);
		
		String img = request.getParameter("img");
		if(img != null)
			carDto.setImg(img);
		
		String price = request.getParameter("price");
		if(price != null)
			carDto.setPrice(price);
		
		String[] date = request.getParameter("carCheckDate").split("-");
		Timestamp carCheckDate = new Timestamp(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1]), Integer.parseInt(date[2]), 0, 0, 0, 0);
		carDto.setCarCheckDate(carCheckDate);
		
		carDao.modifyCar(carDto,no);
		
		response.sendRedirect("admin_carAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
