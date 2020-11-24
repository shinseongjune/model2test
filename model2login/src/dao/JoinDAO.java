package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.Member;

public class JoinDAO {

	private static JoinDAO joinDAO;
	private Connection conn;
	
	private JoinDAO() {
		
	}
	
	
	public static JoinDAO getInstance() {
		if(joinDAO == null) {
			joinDAO = new JoinDAO();
		}
		return joinDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Member newJoin(Member joinMember) {
		Member joinedMember = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joinMember.getId());
			pstmt.setString(2, joinMember.getPasswd());
			pstmt.setString(3, joinMember.getAddr());
			pstmt.setInt(4, joinMember.getAge());
			pstmt.setString(5, joinMember.getEmail());
			pstmt.setString(6, joinMember.getGender());
			pstmt.setString(7, joinMember.getName());
			pstmt.setString(8, joinMember.getNation());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				joinedMember = new Member();
				joinedMember.setId(joinMember.getId());
				joinedMember.setPasswd(joinMember.getPasswd());
				joinedMember.setAddr(joinMember.getAddr());
				joinedMember.setAge(joinMember.getAge());
				joinedMember.setEmail(joinMember.getEmail());
				joinedMember.setGender(joinMember.getGender());
				joinedMember.setName(joinMember.getName());
				joinedMember.setNation(joinMember.getNation());
			}
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return joinedMember;
	}
}
