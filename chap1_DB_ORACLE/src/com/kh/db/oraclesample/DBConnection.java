package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
//		selectBank();
//		selectkhcafe();
//		selectIf();
		insertBank();
	}
		
	static void selectBank() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
		//								����IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM bank ORDER BY 1";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery(); //ResultSet result = ������� ����
			//result.next() : result ��ü���� ���� ��(row)�� �̵�
			//�������� ������ true�� ��ȯ, �׷��� ������ false�� ��ȯ�Ѵ�.
			while(result.next()) {
				//khbank�� �ִ� bank ���̺� ������տ��� account_id(���̸�)�� ������
				int accountID = result.getInt("account_id"); //result set ��� ���տ��� ���� ���� �͸� �����ͼ� ����� ��
				//1. �Բ� �غ��� : accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. �Բ� �غ��� : branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransactionDate ��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				
				System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NUMBER : " + accountNumber + ", ACCOUNT_NAME : " + accountName + 
						", BALANCE : " + balance + ", BRANCH_NAME : " + branchName + ", LAST_TRANSACTION_DATE : " + lastTransactionDate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	static void selectkhcafe() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
				//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
				//								����IP�ּ�:port��ȣ
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khcafe";
				String password = "kh1234";
				Connection con = null;
				//select * from menu �ۼ��ؼ� menu table ��������
				try {
					con = DriverManager.getConnection(url, user, password);
					System.out.println("�����ͺ��̽� ���� ����");
					String selectQuery = "SELECT * FROM cafes ORDER BY 1";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result  = selectState.executeQuery();
					while(result.next()) {
						int cafe_id = result.getInt("CAFE_ID");
						String cname = result.getString("CNAME");
						String address = result.getString("ADDRESS");
						String phone_number = result.getString("PHONE_NUMBER");
						String operating_hours = result.getNString("OPERATING_HOURS");
						System.out.println("CAFE_ID : " + cafe_id + ", CAFENAME : " + cname + ", ADDRESS : " + address + ",PHONE_NUMBER : " + phone_number + ", OPERATING_HOURS : " + operating_hours);
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con = DriverManager.getConnection(url, user, password);
					String selectQuery = "SELECT * FROM menu";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
						int menu_id = result.getInt("MENU_ID");
						int cafe_id = result.getInt("CAFE_ID");
						String menu_name = result.getString("MENU_NAME");
						double price = result.getDouble("PRICE");
						String description = result.getString("DESCRIPTION");
						System.out.println("MENU_ID : " + menu_id + ", CAFE_ID : " + cafe_id + ", MENU_NAME : " + menu_name + ", PRICE : " + price + ", DESCRIPTION : " + description);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
	
	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin�� driver�� ������ �ϱ� ������ String driver = "oracle.jdbc.driver.OracleDriver";�� ��� �Ǵ� ��
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//WHERE�� ����ؼ� ���� �߰� //?�� �־� target�ڵ忡�� ���� �ٲٵ���
//			String selectQuery = "SELECT * FROM BANK WHERE account_id = ?";
//			String selectQuery = "SELECT * FROM BANK WHERE account_name = ?";
//			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?)"; 
//			String selectQuery = "SELECT * FROM BANK WHERE branch_name = ?";
			String selectQuery = "SELECT * FROM BANK WHERE account_id in (?,?,?)";
			
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//���⿡ ���ϴ� ������ account_id ����
//			int targetAID = 1;
//			String targetAN = "������";
//			int targetAN =1236777888;
//			String[] targetAN = {"1234567890","5555666777","3333444555"};
//			String[] targetBN = {"��������"};
			int[] targetAID = {1,2,3};
			
			
			//���� ����
//			selectState.setInt(1, targetAID); //1�� �ڸ���
//			selectState.setString(1, targetAN);
//			selectState.setInt(1, targetAN);

//			selectState.setString(1, targetAN[0]); 
//			selectState.setString(2, targetAN[1]);
//			selectState.setString(3, targetAN[2]); //�ε��� ��Ģ �������� �ʰ� ���� ���缭 �����
			
			selectState.setInt(1, targetAID[0]);
			selectState.setInt(2, targetAID[1]);
			selectState.setInt(3, targetAID[2]);
			
			ResultSet result = selectState.executeQuery();
			
			//�� ���� ����
			if(!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + " ACCOUNT_NUMBER : " + b + " ACCOUNT_NAME : " + c + " BALANCE : " + d + 
						" BRANCH_NAME : " + e + " LAST_TRANSACTION_DATE : " + f);
			}
			if(!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� ����"); //while���� ���� ���¿��� ��µǴ� ���� �翬�ϱ� ������ while �������� �־�����Ѵ�.
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	static void insertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					 + "VALUES (?, ?, ?, ? ,? ,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "123451234");
			insertState.setString(3, "�����");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//
//else {
//	System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
//}

/*
String a = result.getString("���̸�");
char[] charArray = ���̸�.toCharArray();
for(char c : charArray) {
}
*/