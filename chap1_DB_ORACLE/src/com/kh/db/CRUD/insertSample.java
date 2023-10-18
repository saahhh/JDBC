package com.kh.db.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {
		insertOne();
	}
		

	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					 + "VALUES (?, ?, ?, ? ,? ,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "176543219");
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertkhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		//insert문 작성해보기
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BOOK (book_id, title, author, publication_year, isbn, genre, "
					+ "description, price, publication_date, created_date, updated_date, is_available"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 22);
			insertState.setString(2, "timing");
			insertState.setString(3, "kangpool");
			insertState.setDate(4, Date.valueOf("2020-10-17"));
			insertState.setString(5, "978-8954756213");
			insertState.setString(6, "thriller");
			insertState.setString(7, "미스터리스릴러심리썰렁물");
			insertState.setDouble(8, 9.99);
			insertState.setDate(9, Date.valueOf("2019-09-20"));
			insertState.setDate(10, Date.valueOf("2023-10-18"));
			insertState.setDate(11, null);
			insertState.setString(12, null);
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	}

