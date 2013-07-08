package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import model.Circle;

@Component
public class JdbcDaoImpl {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	public Circle getCircle(int circleId){
		
		try {
		
			Connection conn = getDataSource().getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id=?");
			ps.setInt(1, circleId);
			
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				circle = new Circle(circleId,rs.getString("name"));
			}		
			rs.close();
			ps.close();
			conn.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	public int getCircleCount(){
		String sql = "Select count(*) from circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId},String.class);
	}
	
	public Circle getCircleById(int circleId){
		String sql = "select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());			
	}
	
//	public void insertCircle(Circle circle){
//		String sql = "insert into circle (id,name) values (?,?)";
//		jdbcTemplate.update(sql,new Object[]{circle.getId(),circle.getName()});
//	}
	
	public void insertCircle(Circle circle){
		String sql = "insert into circle (id,name) values (:id,:name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	public void createTriangleTable(){
		String sql = "CREATE TABLE TRIANGLE (ID integer, name varchar(50))";
		jdbcTemplate.execute(sql);
	}

	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return jdbcTemplate.getDataSource();
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
}
