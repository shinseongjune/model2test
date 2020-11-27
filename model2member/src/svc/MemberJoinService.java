package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) {
		boolean joinSuccess = false;
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = getConnection();
		memberDAO.setConnection(conn);
		int insertCount = memberDAO.insertMember(member);
		if(insertCount > 0) {
			joinSuccess = true;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return joinSuccess;
	}

}
