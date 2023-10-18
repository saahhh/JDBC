package com.kh.db.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAll {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO products(product_id, product_name, category, price, stock_quantity)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			//"products" 테이블에 데이터 삽입
			insertProduct(ps, 7, "노트북", "전자제품", 899.99, 10);
			insertProduct(ps, 8, "냉장고", "가전제품", 799.99, 20);
			insertProduct(ps, 9, "마우스", "휴대기기", 799.99, 33);
			
			ps.close(); //안써도 무방, 메모리 관리를 위해 써주는 것이 좋음
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
							//PreparedStatement ps 는 왜 쓰는거야? 어떤 데이터를 삽입하기 위해서 쓰이는 것
	static void insertProduct(PreparedStatement ps,int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException {
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}




































