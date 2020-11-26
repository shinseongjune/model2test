package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import vo.Dog;

public class DogDAO {
	private static DogDAO boardDAO;
	private Connection conn;
	
	private DogDAO() {
		
	}
	
	public static DogDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new DogDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Dog> selectDogList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dog");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id"),
							rs.getString("kind"),
							rs.getInt("price"),
							rs.getString("image"),
							rs.getString("country"),
							rs.getInt("height"),
							rs.getInt("weight"),
							rs.getString("content"),
							rs.getInt("readcount")
							));
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) close(rs);
			if (pstmt != null) close(pstmt);
		}
		return dogList;
	}
}
