package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.BoardDao;
import board.BoardDto;
import user.UserDto;
import util.DBManager;

public class CarDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CarDao() {
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	private static CarDao instance = new CarDao();
	public static CarDao getInstance() {
		return instance;
	}

//		 `no`,`name`,`type`,`oil`,`color`,`img`,`price`,`carCheckDate`
	public void createCar(CarDto car) {
		String sql = "INSERT INTO `car`(`no`,`name`,`type`,`number`,`color`,`img`,`price`,`carCheckDate`) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, car.getNo());
			this.pstmt.setString(2, car.getName());
			this.pstmt.setString(3, car.getType());
			this.pstmt.setString(4, car.getNumber());
			this.pstmt.setString(5, car.getColor());
			this.pstmt.setString(6, car.getImg());
			this.pstmt.setString(7, car.getPrice());
			this.pstmt.setTimestamp(8, car.getCarCheckDate());
			
			this.pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstmt.close();
				this.conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public int getLastNo() {
		String sql = "SELECT MAX(`no`) FROM car;";
		int no = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	

	public ArrayList<CarDto> getCarALL(){
		ArrayList<CarDto> list = new ArrayList<CarDto>();
		String sql = "SELECT  * FROM car ORDER BY `no` DESC";
		
		
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
//no , name , type , user, oil, color, img, price, carCheckDate , rentTime , returnTime , check
			while(this.rs.next()) {
				int no = this.rs.getInt(1);
				String name = this.rs.getString(2);
				String type = this.rs.getString(3);
				String number = this.rs.getString(4);
				String user = this.rs.getString(5);
				String oil = this.rs.getString(6);
				String color = this.rs.getString(7);
				String img = this.rs.getString(8);
				String price = this.rs.getString(9);
				Timestamp carCheckDate = this.rs.getTimestamp(10);
				String rentTime = this.rs.getString(11);
				String returnTime = this.rs.getString(12);
				boolean check = this.rs.getBoolean(13);
				
				CarDto car = new CarDto(no , name , type , number , user, oil, color, img, price, carCheckDate , rentTime , returnTime , check);
				list.add(car);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public CarDto getCarByNo(int Getno) {
		CarDto carDto = null;
		String sql = "SELECT * FROM `car` WHERE `no` = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Getno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String number = rs.getString(4);
				String user = rs.getString(5);
				String oil = rs.getString(6);
				String color = rs.getString(7);
				String img = rs.getString(8);
				String price = rs.getString(9);
				Timestamp carCheckDate = rs.getTimestamp(10);
				String rentTime = rs.getString(11);
				String returnTime = rs.getString(12);
				boolean check = rs.getBoolean(13);
				carDto = new CarDto(no,name,type,number,user,oil,color,img,price,carCheckDate,rentTime,returnTime,check);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return carDto;
	}
	
	public void modifyCar(CarDto carDto , int no) {
		String sql = "UPDATE `car` SET `color` = ? , `img` = ?, `price` = ? , `carCheckDate` = ? WHERE `no` = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDto.getColor());
			pstmt.setString(2, carDto.getImg());
			pstmt.setString(3, carDto.getPrice());
			pstmt.setTimestamp(4, carDto.getCarCheckDate());
			pstmt.setInt(5, carDto.getNo());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void bookingCar(CarDto carDto) {
		String sql = "UPDATE `car` SET `user` = ? , `start_date` = ? , `end_date` = ? , `check` = ? WHERE `no` = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDto.getUser());
			pstmt.setString(2, carDto.getRentTime());
			pstmt.setString(3, carDto.getReturnTime());
			pstmt.setBoolean(4, carDto.isCheck());
			pstmt.setInt(5, carDto.getNo());
			
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<CarDto> getCarByUser(String id) {
		ArrayList<CarDto> carDto = new ArrayList<>();
		String sql = "SELECT * FROM `car` WHERE `user` = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String number = rs.getString(4);
				String user = rs.getString(5);
				String oil = rs.getString(6);
				String color = rs.getString(7);
				String img = rs.getString(8);
				String price = rs.getString(9);
				Timestamp carCheckDate = rs.getTimestamp(10);
				String rentTime = rs.getString(11);
				String returnTime = rs.getString(12);
				boolean check = rs.getBoolean(13);
				carDto.add(new CarDto(no,name,type,number,user,oil,color,img,price,carCheckDate,rentTime,returnTime,check));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		boolean check2 = false;
		for(int i = 0; i<carDto.size();i++) {
			if(carDto.get(i).getUser().equals(id)) {
				check2 = true;
			}
		}
		if(check2) {
		return carDto;
		}else {
			return null;
		}
	}
	
	public void deleteCar(int no) {
		
		String sql = "Delete from car where no = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int changeTime(String[] time) {
		String time2 = "";
		for(int i = 0; i<time.length;i++) {
			time2 += time[i];
		}
		int intTime = Integer.parseInt(time2);
		return intTime;
	}

}
