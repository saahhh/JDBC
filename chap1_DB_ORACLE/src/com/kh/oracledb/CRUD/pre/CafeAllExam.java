package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CafeAllExam {

	public static void main(String[] args) {
		/*
		1. 모든 카페 목록 가져오기
		Statement st1 = con.createStatement();
		ResultSet result1 = st1.executeQuery();
		2. 특정 카페의 메뉴 가져오기
		3. 새로운 카페 추가하기
		4. 특정 카페의 메뉴가격 변경
		5. 특정 카페의 정보 수정하기
		6. 특정 카페의 정보 삭제하기
		7. 특정 카페의 메뉴 수 가져오기
		8. 특정 가격범위 내의 모든 메뉴 가져오기 */
		
		selectcafemenu();
		insertcafe1();
		
	}
		static void selectcafe() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "kh1234";
			
			try {
				Connection con = DriverManager.getConnection(jdbcurl, username, password);
				String selectSQL = "SELECT cname FROM cafes";
				Statement st1 = con.createStatement();
				ResultSet result1 = st1.executeQuery(selectSQL);
				System.out.println("카페 목록 : ");
				
				while(result1.next()) {
					String cname = result1.getString("cname");
					System.out.println(cname);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		static void selectcafemenu() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "kh1234";
			
			try {
				Connection con = DriverManager.getConnection(jdbcurl, username, password);
				String selectSQL = "SELECT menu_name FROM menu m join cafes c ON m.cafe_id = c.cafe_id WHERE c.cafe_id = ?";
				PreparedStatement st2 = con.prepareStatement(selectSQL);
				st2.setInt(1, 1);
				ResultSet result2 = st2.executeQuery();
				
				System.out.println("카페 메뉴 : ");
				
				while(result2.next()) {
//					String menu_name = result2.getString("menu_name");
					String menu_name = result2.getString("menu_name");
					System.out.println(menu_name);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		static void insertcafe1() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "kh1234";
			
			try {
				Connection con = DriverManager.getConnection(jdbcurl, username, password);
				String insertSQL = "INSERT INTO cafes(cname, address, phone_number, operationg_hours) VALUES(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(insertSQL);
				insertcafe1(st, "스타벅스강남점", "서울시 강남구", "02-575-6666", "매일 : 07:00 - 23:00");
				st.setString(1, cname);
				st.setString(2, address);
				st.setString(3, phone_number);
				st.setString(4, operating_hours);
				st.close();
				System.out.println("");
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

	}	




