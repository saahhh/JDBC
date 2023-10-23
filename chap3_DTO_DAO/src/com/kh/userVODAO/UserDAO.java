package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			st.setDate(4,new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
