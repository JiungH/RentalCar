package car;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarAddAction
 */
@WebServlet("/CarAddAction")
public class CarAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CarDao carDao = CarDao.getInstance();
		CarDto carDto = null;
		
		
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name"); 
		String type = request.getParameter("type"); 
		String number = request.getParameter("number"); 
		String color = request.getParameter("color"); 
		String img = request.getParameter("img"); 
		String price = request.getParameter("price"); 
		String[] date = request.getParameter("carCheckDate").split("-");
		Timestamp carCheckDate = new Timestamp(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1]), Integer.parseInt(date[2]), 0, 0, 0, 0);
		
		carDto = new CarDto(no,name,type,number,color,img,price,carCheckDate);
		carDao.createCar(carDto);
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
