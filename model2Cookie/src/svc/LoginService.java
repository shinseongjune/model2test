package svc;

import java.sql.Connection;

import dao.LoginDAO;

import static db.JdbcUtil.*;
import vo.Member;

public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection conn = getConnection();
		loginDAO.setConnection(conn);
		Member loginMember = loginDAO.selectLoginMember(id,passwd);
		close(conn);
		return loginMember;
	}

}
