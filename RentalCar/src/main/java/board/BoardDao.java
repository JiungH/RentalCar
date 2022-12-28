package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 단일한 인스턴스 제공 
	// Singletone 으로 구현 
	private BoardDao() {
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	public void createBoard(BoardDto board) {
		String sql = "INSERT INTO `board`(`no`,`title`,`content`,`user`,`password`) VALUES(?,?,?,?,?)";
		int no = noGenerator(); // 마지막 no +1 
		
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, no); 
			this.pstmt.setString(2, board.getTitle());
			this.pstmt.setString(3, board.getContent());
			this.pstmt.setString(4, board.getUser());
			this.pstmt.setString(5, board.getPassword());
			
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private int noGenerator() {
		String sql = "SELECT MAX(`no`) FROM board;";
		int no = 0;
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				no = this.rs.getInt(1);
			}
		} catch (Exception e) {
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
		return ++no;
	}
	
	// Read 
	// 1. All 
	public ArrayList<BoardDto> getBoardAll() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "SELECT * FROM board ORDER BY `no` DESC";
		
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int no = this.rs.getInt(1);
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				String password = this.rs.getString(5);
				Timestamp regDate = this.rs.getTimestamp(6);
				Timestamp modDate = this.rs.getTimestamp(7);
				int viewCnt = this.rs.getInt(8);
				
				BoardDto board = new BoardDto(no, title, content, user, password, regDate, modDate, viewCnt);
				list.add(board);
			}
		} catch (Exception e) {
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
	
	// 2. one 
	public BoardDto getBoardByNo(int no) {
		BoardDto board = null;
		String sql = "SELECT * FROM board WHERE `no` = ?";
		
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				String password = this.rs.getString(5);
				Timestamp regDate = this.rs.getTimestamp(6);
				Timestamp modDate = this.rs.getTimestamp(7);
				int viewCnt = this.rs.getInt(8);
				
				board = new BoardDto(no, title, content, user, password, regDate, modDate, viewCnt);
			}
		} catch (Exception e) {
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
		return board;
	}
	
	public ArrayList<BoardDto> getBoardById(String user) {
		ArrayList<BoardDto>list = new ArrayList<>();
		String sql = "SELECT * FROM board WHERE `user` = ? order by regDate desc";
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user);
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()) {
				int no = this.rs.getInt(1);
				String title = this.rs.getString(2);
				Timestamp regDate = this.rs.getTimestamp(6);
				Timestamp modDate = this.rs.getTimestamp(7);
				int viewCnt = this.rs.getInt(8);
				list.add(new BoardDto(no, title, regDate, modDate, viewCnt));
			}
		} catch (Exception e) {
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
	
	
	
	// Update
	public void updateBoard(BoardDto board) {
		
		String sql = "update board set title = ?, content = ?, modDate = now() where `no` = ?;";
		int no = board.getNo();
		String title = board.getTitle();
		String content = board.getContent();
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, title);
			this.pstmt.setString(2, content);
			this.pstmt.setInt(3, no);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//delete
	
	public void deleteBoard(int no) {
		BoardDto board = null;
		String sql = "DELETE FROM board where `no`= ?;";
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1 , no);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addViewCnt(int viewCnt , int no) {
		String sql = "update board set viewCnt = ? where `no` = ?;";
		try {
			this.conn = DBManager.getConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, viewCnt); 
			this.pstmt.setInt(2, no);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}