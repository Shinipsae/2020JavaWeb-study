package servletex.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyService {
	public String service(HttpServletRequest req, HttpServletResponse resp);
}
