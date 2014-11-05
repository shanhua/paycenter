package com.jinyinmao.pay.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jinyinmao.pay.dao.UserAuthDao;
import com.jinyinmao.pay.dao.UserAuthRowMapper;
import com.jinyinmao.pay.model.UserAuth;

public class JdbcUserAuthDao extends JdbcDaoSupport implements UserAuthDao {
	/*使用jdbcsupport无需声明使用dataSource
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	*/
	
	private JdbcTemplate jdbcTemplate;
	
	public void insert(UserAuth userAuth) {
		String sql = "insert into T01_USER_AUTHS" +
					 "(USER_AUTH_ID, SN, MOBILE_NO) values (?, ?, ?)";
		getJdbcTemplate().update(sql,  new Object[] { userAuth.getUserAuthId(),
					userAuth.getSn(), userAuth.getMobileNo()});
		/*使用 spring JdbcTemplate 用法
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { userAuth.getUserAuthId(),
					userAuth.getSn(), userAuth.getMobileNo()});
		*/
		
 /*		基本jdbc 用法
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userAuth.getUserAuthId());
			ps.setString(2, userAuth.getSn());
			ps.setString(3, userAuth.getMobileNo());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if (conn != null){
				try{
					conn.close();
				}catch(SQLException e){}
			}
		}
	*/			
	}
	
	public UserAuth findBySn(String sn){
		String sql = "select * from T01_USER_AUTHS where sn = ?";
//		jdbcTemplate = new JdbcTemplate(dataSource);
		UserAuth userAuth = getJdbcTemplate().queryForObject(sql, new Object[] {sn}, new UserAuthRowMapper());
		return userAuth;
//		Connection conn = null;
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, sn);
//			UserAuth userAuth = null;
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				userAuth = new UserAuth();
//				userAuth.setUserAuthId(rs.getInt("USER_AUTH_ID"));
//				userAuth.setSn(rs.getString("SN")); 
//				userAuth.setMobileNo(rs.getString("MOBILE_NO"));
//				
//			}
//			rs.close();
//			ps.close();
//			return userAuth;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				try {
//				conn.close();
//				} catch (SQLException e) {}
//			}
//		}
	}
	
}