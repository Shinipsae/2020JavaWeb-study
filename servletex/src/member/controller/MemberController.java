package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import servletex.model.MyService;

public class MemberController implements MyService{
	private MemberDao memberDao = null;
	private MemberService memberService = null;
	
	public MemberController() {
		memberDao = MemberDao.getInstance();
		memberService = new MemberServiceImpl(memberDao);
	}
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println("cmd:" + cmd);
		String view = null;
		switch(cmd) {
		case "list":view = memberService.selectAll(req, resp);break;
		case "insert":view = memberService.insertMember(req, resp);break;
		case "info":view = memberService.selectMember(req, resp);break;
		}
		return view;
	}

}
