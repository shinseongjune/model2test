package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import javax.sql.DataSource;

import vo.MemberBean;

public class MemberDAO {
	private static MemberDAO memberDAO;
	private Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "SELECT id FROM member WHERE id = ? AND pw = ?";
		
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("id");
			}
		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}

	public int insertMember(MemberBean member) {
		String sql = "INSERT INTO member VALUES (?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("joinMember 에러: " + e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM member";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					mb = new MemberBean();
					mb.setId(rs.getString("id"));
					mb.setPw(rs.getString("pw"));
					mb.setAge(rs.getInt("age"));
					mb.setGender(rs.getString("gender"));
					mb.setEmail(rs.getString("email"));
					memberList.add(mb);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getDetailMember 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
}
