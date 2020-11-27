package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);
		ActionForward forward = null;
		if (loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getId());
			forward.setRedirect(true);
			forward.setPath("./memberListAction.do");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 실패');location.href='./memberLogin.do';</script>");
		}
		return forward;
	}

}
