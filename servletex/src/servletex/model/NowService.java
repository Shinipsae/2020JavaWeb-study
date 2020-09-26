package servletex.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowService implements MyService{
	
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		Date now = new Date();
		System.out.println("처리");
		req.setAttribute("now", now);
		return "/view/now.jsp";
	}
	

}










