package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;

public class JoinService2 {

	public static int insertMember(Member member) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection conn = getConnection();
		loginDAO.setConnection(conn);
		int joinMember = loginDAO.insertMember(member);
		close(conn);
		return joinMember;
	}
}
