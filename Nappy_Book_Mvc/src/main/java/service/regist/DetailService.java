package service.regist;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.RegistDAO;
import domain.RegistDTO;
import service.Service;
import sqlmapper.SqlSessionManager;

public class DetailService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		SqlSession sqlSession = null;
		RegistDAO dao = null;		
		
		List<RegistDTO> list = null;
		
		try {
			sqlSession = SqlSessionManager.getInstance().openSession();
			dao = sqlSession.getMapper(RegistDAO.class);
			
			// 조회수 증가 + 상세 읽기
			dao.incViewCnt(id);
			list = dao.selectById(id);
			
			request.setAttribute("list", list);
			
			sqlSession.commit();
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {
			if(sqlSession!= null) sqlSession.close();
		}		

	}

}










