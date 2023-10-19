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
		1. ��� ī�� ��� ��������
		Statement st1 = con.createStatement();
		ResultSet result1 = st1.executeQuery();
		2. Ư�� ī���� �޴� ��������
		3. ���ο� ī�� �߰��ϱ�
		4. Ư�� ī���� �޴����� ����
		5. Ư�� ī���� ���� �����ϱ�
		6. Ư�� ī���� ���� �����ϱ�
		7. Ư�� ī���� �޴� �� ��������
		8. Ư�� ���ݹ��� ���� ��� �޴� �������� */
		
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
				System.out.println("ī�� ��� : ");
				
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
				
				System.out.println("ī�� �޴� : ");
				
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
				insertcafe1(st, "��Ÿ����������", "����� ������", "02-575-6666", "���� : 07:00 - 23:00");
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




