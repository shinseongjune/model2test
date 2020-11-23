package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.JoinService;
import vo.ActionForward;
import vo.Member;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		Member joinMember = new Member();
		joinMember.setId(request.getParameter("id"));
		joinMember.setPasswd(request.getParameter("passwd"));
		joinMember.setAddr(request.getParameter("addr"));
		joinMember.setAge(Integer.parseInt(request.getParameter("age")));
		joinMember.setEmail(request.getParameter("email"));
		joinMember.setGender(request.getParameter("gender"));
		joinMember.setName(request.getParameter("name"));
		joinMember.setNation(request.getParameter("nation"));
		JoinService joinService = new JoinService();
		Member joinedMember = joinService.getJoinedMember(joinMember);
		
		if(joinedMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", joinedMember);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입 실패');history.back();</script>");
		}
		
		return forward;
	}

}
