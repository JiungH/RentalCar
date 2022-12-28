package user;

import java.sql.Timestamp;

public class UserDto {
	private int no;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String gender;
	private String phone;
	private String email;
	private Timestamp resDate;
	private boolean manager;
	
	public UserDto(int no, String id, String password, String name, String nickname, String gender, String phone,
			String email, Timestamp resDate, boolean manager) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.resDate = resDate;
		this.manager = manager;
	}
	
	public UserDto(int no, String id, String password, String name, String nickname, String gender, String phone,
			String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}
	
	

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Timestamp getResDate() {
		return resDate;
	}

	public boolean isManager() {
		return manager;
	}

//	public void setNo(int no) {
//		this.no = no;
//	}

//	public void setId(String id) {
//		this.id = id;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public void setResDate(Timestamp resDate) {
//		this.resDate = resDate;
//	}

//	public void setManager(boolean manager) {
//		this.manager = manager;
//	}
	
	
	
	
}
