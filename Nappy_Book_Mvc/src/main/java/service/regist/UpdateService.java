package service.regist;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.RegistDAO;
import domain.RegistDTO;
import service.Service;
import sqlmapper.SqlSessionManager;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 입력합 값 (parameter) 받아오기
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String summary = request.getParameter("summary");
		// ※ 이 단계에서 parameter 검증 해야 한다.
		
		SqlSession sqlSession = null;
		RegistDAO dao = null;		
		
		int cnt = 0;
		
		// Builder 사용한 생성
		RegistDTO dto = RegistDTO.builder()
			.id(id)
			.title(title)
			.price(price)
			.summary(summary)
			.build()
			;
		
		
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(RegistDAO.class);
			
			cnt = dao.update(dto);
			
			sqlSession.commit();
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {
			if(sqlSession!= null) sqlSession.close();
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("dto", dto);  // id 값을 전달하기 위해


	}

}















