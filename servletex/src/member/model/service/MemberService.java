package member.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public String selectAll(HttpServletRequest req, HttpServletResponse resp);
	public String selectMember(HttpServletRequest req, HttpServletResponse resp);
	public String insertMember(HttpServletRequest req, HttpServletResponse resp);
	public String updateMember(HttpServletRequest req, HttpServletResponse resp);
	public String deleteMember(HttpServletRequest req, HttpServletResponse resp);
}
