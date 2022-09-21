package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.regist.DeleteService;
import service.regist.DetailService;
import service.regist.ListService;
import service.regist.SelectService;
import service.regist.UpdateService;
import service.regist.RegistService;

@WebServlet("/book/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");   // 한글 인코딩
		action(request, response);
	}

	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n>> " + getClass().getName() + ".action() 호출");
		
		String uri = request.getRequestURI();  
		String conPath = request.getContextPath();  
		String command = uri.substring(conPath.length());
		
		String method = request.getMethod();
		
		Service service = null;  
		String viewPage = null;  
		
		switch(command) {
		case "/book/regist":
			switch(method) {
			case "GET":
				viewPage = "regist.jsp";
				break;
			case "POST":
				service = new RegistService();
				service.execute(request, response);
				viewPage = "registOk.jsp";
				break;
			}
			break;
		case "/book/list":
			service = new ListService();
			service.execute(request, response);
			viewPage = "list.jsp";
			break;
			
		case "/book/detail":
			service = new DetailService();
			service.execute(request, response);
			viewPage = "detail.jsp";
			break;
			
		case "/book/update":
			switch(method) {
			case "GET":
				service = new SelectService();
				service.execute(request, response);
				viewPage = "update.jsp";
				break;
			case "POST":
				service = new UpdateService();
				service.execute(request, response);
				viewPage = "updateOk.jsp";
				break;
			}
			break;
			
		case "/book/delete":
			switch(method) {
			case "POST":
				service = new DeleteService();
				service.execute(request, response);
				viewPage = "deleteOk.jsp";
				break;
			}
			break;
		} // end switch
		
		// 위에서 결정된 뷰 페이지 (viewPage) 로 forward 해줌
		if(viewPage != null) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/WEB-INF/views/board/" + viewPage);
			
			dispatcher.forward(request, response);
		}
	
	
	} // end action()

} // end Controller











