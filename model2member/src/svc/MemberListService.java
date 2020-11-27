package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList() {
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		close(conn);
		return memberList;
	}

}
