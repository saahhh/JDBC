package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAllExam {

	public static void main(String[] args) throws SQLException {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
		
			try {
				//���� 1ȸ �����ͺ��̽� ���� ����
				Connection con = DriverManager.getConnection(jdbcurl, userName, password);
				String insertSQL = "INSERT INTO book(book_id, title, author, publication_year, isbn, genre, description, price, publication_date, is_available)"
									+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
											//"VALUES(?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)";
				PreparedStatement ps = con.prepareStatement(insertSQL);
				insertbook(ps, 23, "Ÿ�̹�", "��Ǯ", 2020, "978-7777888899", "Thriller", "�̽��͸��������ɸ��䷷��", 21.99, "2023-10-17", "Y");
				insertbook(ps, 52, "������ ���1", "����������", 2023, "978-1234567111", "�ɸ���", "���� ���� 1", 8.99, "2023-10-18", "Y");
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
			//INSERT INTO book (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, is_available
		public static void insertbook(PreparedStatement ps, int book_id, String title, String author, int publication_year, String isbn, String genre, String description, Double price, String publication_date, String is_available) throws SQLException {
			ps.setInt(1, book_id);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setInt(4, publication_year);
			ps.setString(5, isbn);
			ps.setString(6, genre);
			ps.setString(7, description);
			ps.setDouble(8, price);
			ps.setString(9, publication_date);
			ps.setString(10, is_available);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				System.out.println("å " + title + " �����ϴ�.");
			} else {
					System.out.println("���� å�� �����ϴ�.");
			}
			
		}
}
	
