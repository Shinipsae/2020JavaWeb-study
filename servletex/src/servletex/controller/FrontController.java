package servletex.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletex.model.AddService;
import servletex.model.MyService;
import servletex.model.NowService;

//클라이언트의 요청을 구분
//구분된 요청에 따라 로직을 선택
//로직 결과에 따라 적절한 뷰(jsp)를 선택하여 응답
public class FrontController extends HttpServlet{
	
	Map<String, MyService> svc = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		svc.put("/servletex/now", new NowService());
		svc.put("/servletex/add", new AddService());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		String uri = req.getRequestURI();
		String viewPath = "";
		System.out.println("요청URI:" + req.getContextPath()+"/now");
		if(uri.equals(req.getContextPath()+"/now")) {
			MyService ms = svc.get(uri);
			viewPath = ms.service(req, resp);
			System.out.println(viewPath);
		}if(uri.equals(req.getContextPath()+"/add")) {
			MyService ms = svc.get(uri);
			if(req.getMethod().equals("GET")){
				viewPath = ms.service(req, resp);
			}else {
				viewPath = ms.service(req, resp);
			}
			System.out.println("viewpage:" + viewPath);
		}else {
			return;
		}
		req.getRequestDispatcher(viewPath).forward(req, resp);
	}
}
