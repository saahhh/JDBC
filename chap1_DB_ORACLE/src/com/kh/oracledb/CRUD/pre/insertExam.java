package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {
	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, password);
			String insertSQL = "INSERT INTO cafes(cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertcafes(ps, "스벅포스코타워", "서울시 강남구 역삼동 포스코타워", "02-576-9213", "매일 : 07:00 - 23:00");
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
	static void insertcafes(PreparedStatement ps, String cname, String address, String phone_number, String operating_hours) throws SQLException  {
		ps.setString(1, cname);
		ps.setString(2, address);
		ps.setString(3, phone_number);
		ps.setString(4, operating_hours);
		
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert + "row 추가됨");
	}
	
}
		
