package domain;

import java.sql.SQLException;
import java.util.List;

public interface RegistDAO {
	public abstract int insert(RegistDTO dto) throws SQLException;
	
	public abstract List<RegistDTO> selectById(int id) throws SQLException;
	
	public abstract int incViewCnt(int id) throws SQLException;
	
	public abstract List<RegistDTO> select() throws SQLException;
	
	public abstract int update(RegistDTO dto) throws SQLException;
	
	public abstract int deleteById(int id) throws SQLException;
	
} // end DAO



















