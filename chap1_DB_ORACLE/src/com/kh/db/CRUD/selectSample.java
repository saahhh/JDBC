package com.kh.db.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectSample {

	public static void main(String[] args) {
		selectAll();
		selectOne();
	}
		
	static void selectAll() {
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
		
		static void selectOne() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin�� driver�� ������ �ϱ� ������ String driver = "oracle.jdbc.driver.OracleDriver";�� ��� �Ǵ� ��
			String user = "khbank";
			String password = "kh1234";
			Connection con = null;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				//WHERE�� ����ؼ� ���� �߰� //?�� �־� target�ڵ忡�� ���� �ٲٵ���
//				String selectQuery = "SELECT * FROM BANK WHERE account_id = ?";
//				String selectQuery = "SELECT * FROM BANK WHERE account_name = ?";
//				String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?)"; 
//				String selectQuery = "SELECT * FROM BANK WHERE branch_name = ?";
				String selectQuery = "SELECT * FROM BANK WHERE account_id in (?,?,?)";
				
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				
				//���⿡ ���ϴ� ������ account_id ����
//				int targetAID = 1;
//				String targetAN = "������";
//				int targetAN =1236777888;
//				String[] targetAN = {"1234567890","5555666777","3333444555"};
//				String[] targetBN = {"��������"};
				int[] targetAID = {1,2,3};
				
				
				//���� ����
//				selectState.setInt(1, targetAID); //1�� �ڸ���
//				selectState.setString(1, targetAN);
//				selectState.setInt(1, targetAN);

//				selectState.setString(1, targetAN[0]); 
//				selectState.setString(2, targetAN[1]);
//				selectState.setString(3, targetAN[2]); //�ε��� ��Ģ �������� �ʰ� ���� ���缭 �����
				
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

	}
	


	




