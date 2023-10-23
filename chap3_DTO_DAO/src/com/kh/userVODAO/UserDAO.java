package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection; 
	
	public UserDAO(Connection connection) {
		this.connection = connection;	
	}
	
	public boolean createUser(/*파라미터 값 추가*/ UserVO user) {
		String sql = "INSERT INTO USERINFO (user_id, user_name, email, reg_date)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId()); //파라미터값에추가
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO";
		//try - with - resources 구문
		//데이터베이스 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
		try (PreparedStatement st = connection.prepareStatement(sql)) { //메모리를 상대적으로 작게 쓰임		
			ResultSet rs = st.executeQuery();
			//selectOne If / selctAll while
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setRegDate(rs.getDate("reg_date"));
				
				users.add(user);				
			}
		} return users; //Finally 오류 : try ()에 prepared~코드 넣어주면 해결
	}
}
