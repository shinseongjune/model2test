package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.JoinDAO;
import vo.Member;

public class JoinService {

	public Member getJoinedMember(Member joinMember) {
		JoinDAO joinDAO = JoinDAO.getInstance();
		Connection conn = getConnection();
		joinDAO.setConnection(conn);
		Member joinedMember = joinDAO.newJoin(joinMember);
		return joinedMember;
	}

}
