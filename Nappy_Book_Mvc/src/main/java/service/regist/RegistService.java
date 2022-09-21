package service.regist;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.RegistDAO;
import domain.RegistDTO;
import service.Service;
import sqlmapper.SqlSessionManager;

public class RegistService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 입력한 값을 받아오기
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String summary = request.getParameter("summary");

		
		// 위 값들을 DTO에 담기
		RegistDTO dto = new RegistDTO();
		dto.setTitle(title);
		dto.setPrice(price);
		dto.setSummary(summary);
		
		int cnt = 0;
		
		SqlSession sqlSession = null;  // 트랜잭션을 위한 객체
		RegistDAO dao = null;
				
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(RegistDAO.class); // MyBatis 가 생성한 DAO
			
			cnt = dao.insert(dto);  
			System.out.println("글작성 체크 " + cnt + " : " + dto.getId());
			
			sqlSession.commit();  
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("dto", dto);  // auto-generated key(id)

	} // end execute()

} // end Command
















