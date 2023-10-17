package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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
			String selectQuery = "SELECT * FROM bank";
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
				String lastTransactionDate = result.getString("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NUMBER : " + accountNumber + ", ACCOUNT_NAME : " + accountName + 
						", BALANCE : " + balance +", BRANCH_NAME : " + branchName + ", LAST_TRANSACTION_DATE : " + lastTransactionDate);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
