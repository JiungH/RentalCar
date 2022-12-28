package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}

	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
							
	public void createUser(UserDto userDto) {
		String sql = "INSERT INTO `user`(`no`,id,`password`,`name`,nickname,gender,phone,email) VALUES(?, ?, ?, ?, ?, ?, ? , ?)";

		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);

			this.pstmt.setInt(1, userDto.getNo());
			this.pstmt.setString(2, userDto.getId());
			this.pstmt.setString(3, userDto.getPassword());
			this.pstmt.setString(4, userDto.getName());
			this.pstmt.setString(5, userDto.getNickname());
			this.pstmt.setString(6, userDto.getGender());
			this.pstmt.setString(7, userDto.getPhone());
			this.pstmt.setString(8, userDto.getEmail());

			this.pstmt.execute();
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

	public ArrayList<UserDto> getUserAll() {
		ArrayList<UserDto> result = new ArrayList<>();
		String sql = "SELECT * FROM user";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String nickname = rs.getString(5);
				String gender = rs.getString(6);
				String phone = rs.getString(7);
				String email = rs.getString(8);
				Timestamp resDate = rs.getTimestamp(9);
				boolean manager = rs.getBoolean(10);
				result.add(new UserDto(no, id, password, name, nickname, gender, phone,email, resDate, manager));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getLastNo() {
		String sql = "SELECT MAX(no) FROM user";

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

	public void modifyUser(UserDto user, int no) {
		String sql = "UPDATE `user` SET `password` = ? , `name` = ?, `nickname` = ?, phone = ? WHERE `no` = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getNickname());
			pstmt.setString(4, user.getPhone());
			pstmt.setInt(5, user.getNo());

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
	

	public UserDto getUserById(String id) {
		UserDto dto = null;
		String sql = "SELECT * FROM `user` WHERE id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt(1);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String nickname = rs.getString(5);
				String gender = rs.getString(6);
				String phone = rs.getString(7);
				String email = rs.getString(8);
				Timestamp resDate = rs.getTimestamp(9);
				boolean manager = rs.getBoolean(10);

				dto = new UserDto(no, id, password, name, nickname, gender, phone,email ,resDate, manager);
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
		return dto;
	}
	
	public ArrayList<String> getIdAll() {
		ArrayList<String>idAll = new ArrayList<>();
		String sql = "SELECT id FROM user";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				idAll.add(id);
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
		return idAll;
	}

	public void deleteUser(String id) {
		String sql = "DELETE FROM user WHERE id=?";
		try {
			conn = DBManager.getConnection();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
}

