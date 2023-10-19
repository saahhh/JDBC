package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public void insertCafe(String cname, String address, String phone_number, String operating_hours) { //�޼ҵ�� �����ϴ� ������ ������ִ°�
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("���� ����!");
			String SQL = "INSERT INTO cafes(cname, address, phone_number, operationg_hours)" + "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, cname);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateMenu(int menu_id, int cafe_id, String description) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET description = ? WHERE menu_id = ? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menu_id);
			st.setInt(3, cafe_id);
			
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
						//(�Ű����� �߰��ϱ�)
	public void UpdateCafe(int cafe_id, String operating_hours) {//ī�� ��ð� �����ϱ�
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, operating_hours);
			st.setInt(2, cafe_id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
						//()���� �Ű�����(=�Ķ����)�� �� �߰�������Ѵ�.
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafe_id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMenu(int menu_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM menu WHERE menu_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menu_id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
