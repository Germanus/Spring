package dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport{
	
	public int getCircleCount(){
		String sql = "select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
