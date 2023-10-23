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
	
	public boolean createUser(/*�Ķ���� �� �߰�*/ UserVO user) {
		String sql = "INSERT INTO USERINFO (user_id, user_name, email, reg_date)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId()); //�Ķ���Ͱ����߰�
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //���� ������ 0���� Ŀ���Ƿ� true�� ��
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO";
		//try - with - resources ����
		//�����ͺ��̽� ���ҽ��� �����ϰ� ����ϰ� �ڵ����� �ݾ��ֱ� ���ؼ� ���Ǵ� ���
		try (PreparedStatement st = connection.prepareStatement(sql)) { //�޸𸮸� ��������� �۰� ����		
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
		} return users; //Finally ���� : try ()�� prepared~�ڵ� �־��ָ� �ذ�
	}
}
