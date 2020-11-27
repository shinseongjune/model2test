package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = null;
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.do");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자가 아닙니다.');location.href='./memberLogin.do';</script>");
		} else {
			forward = new ActionForward();
			MemberListService memberListService = new MemberListService();
			ArrayList<MemberBean> memberList = memberListService.getMemberList();
			request.setAttribute("memberList", memberList);
			forward.setPath("./memberList.jsp");
		}
		return forward;
	}

}
