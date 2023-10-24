package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "khbank";
		String pw = "kh1234";
		
		try {
			Connection c = DriverManager.getConnection(url, name, pw);
			Scanner sc = new Scanner(System.in);
			System.out.println("전송할 ID를 입력하세요 : ");
			int fromAccountId = sc.nextInt();
			
			System.out.println("전송할 금액을 입력하세요 : ");
			double amount = sc.nextDouble();
			
			PreparedStatement a = c.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE account_id = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			c.commit();
			
			PreparedStatement b = c.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE account_id = ?");
			b.setDouble(1, amount);
			b.setInt(2, fromAccountId);
			b.executeUpdate();
			c.commit();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
