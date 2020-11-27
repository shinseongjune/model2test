package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean member = new MemberBean();
		boolean joinResult = false;
		
		try {
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setAge(Integer.parseInt(request.getParameter("age")));
			member.setGender(request.getParameter("gender"));
			member.setEmail(request.getParameter("email"));
		} catch (Exception e) {
			
		}
		
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(member);
		
		ActionForward forward = null;
		if(joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원등록실패');history.back();</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.do");
		}
		
		return forward;
	}

}
