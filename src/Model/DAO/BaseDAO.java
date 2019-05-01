package Model.DAO;

import java.util.List;

import Model.Mapper.RowMapper;

public interface BaseDAO <T>{
	<T> List<T> Query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void Update (String sql, Object... parameters);
	Integer Insert (String sql, Object... parameters);
	int Count(String sql, Object... parameters);
	void Delete (String sql,Object... parameters);
	
	
}
