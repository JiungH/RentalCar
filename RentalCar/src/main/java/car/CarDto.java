package car;

import java.sql.Timestamp;

public class CarDto {

	private int no;
	private String name;
	private String type;
	private String number;
	private String user;
	private String oil;  // 오일양
	private String color; // 색상 
	private String img; // 이미지 
	private String price;
	private Timestamp carCheckDate; // 자동차 전체 점검 날짜
	private String rentTime; // 렌트시작 시간 
	private String returnTime; // 렌트 반납시간 
	private boolean check;
	
	
	public CarDto(int no, String name, String type, String number, String user, String oil, String color, String img, String price ,Timestamp carCheckDate,
			String rentTime, String returnTime, boolean check) {
		super();
		this.no = no;
		this.name = name;
		this.type = type;
		this.number = number;
		this.user = user;
		this.oil = oil;
		this.color = color;
		this.img = img;
		this.price = price;
		this.carCheckDate = carCheckDate;
		this.rentTime = rentTime;
		this.returnTime = returnTime;
		this.check = check;
	}

	public CarDto(int no, String name, String type, String number, String color, String img, String price ,Timestamp carCheckDate) {
		super();
		this.no = no;
		this.name = name;
		this.type = type;
		this.number = number;
		this.color = color;
		this.img = img;
		this.price = price;
		this.carCheckDate = carCheckDate;
	}

	public int getNo() {
		return no;
	}


	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}
	
	public String getNumber() {
		return number;
	}

	public String getUser() {
		return user;
	}

	public String getOil() {
		return oil;
	}


	public String getColor() {
		return color;
	}


	public String getImg() {
		return img;
	}
	
	public String getPrice() {
		return price;
	}


	public Timestamp getCarCheckDate() {
		return carCheckDate;
	}


	public String getRentTime() {
		return rentTime;
	}


	public String getReturnTime() {
		return returnTime;
	}


	public boolean isCheck() {
		return check;
	}


//	public void setNo(int no) {
//		this.no = no;
//	}


	public void setName(String name) {
		this.name = name;
	}


//	public void setType(String type) {
//		this.type = type;
//	}
	
//	public void setNumber(String number) {
//		this.number = number;
//	}


	public void setOil(String oil) {
		this.oil = oil;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public void setImg(String img) {
		this.img = img;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}


	public void setCarCheckDate(Timestamp carCheckDate) { // 
		this.carCheckDate = carCheckDate;
	}


	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}


	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}


	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	
}
