package member.model.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.persistence.Member;

public class MemberServiceImpl implements MemberService{
	MemberDao memberDao = null;
	
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public String selectAll(HttpServletRequest req, HttpServletResponse resp) {
		List<Member> list = memberDao.selectAll();
		req.setAttribute("list", list);
		return "/member/list.jsp";
	}

	@Override
	public String selectMember(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Member member = memberDao.selectMember(id);
		req.setAttribute("member", member);
		return "/member/info.jsp";
	}

	@Override
	public String insertMember(HttpServletRequest req, HttpServletResponse resp) {
		String method = req.getMethod();
		String view = "/member/regist.jsp";
		if(method.equals("POST")){
			if(req.getParameter("pw").equals(req.getParameter("pw2"))) {
				Member member = new Member(0, 
						req.getParameter("id"),
						req.getParameter("pw"),
						req.getParameter("name"));
				memberDao.insertMember(member);
				req.setAttribute("name", member.getName());
				view = "/member/registSuccess.jsp";
			}
		}
		return view;
	}

	@Override
	public String updateMember(HttpServletRequest req, HttpServletResponse resp) {
		// Member member, int seq
		
		return null;
	}

	@Override
	public String deleteMember(HttpServletRequest req, HttpServletResponse resp) {
		// int seq
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		return null;
	}

}
