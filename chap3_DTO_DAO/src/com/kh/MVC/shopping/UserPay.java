package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khbank";
	String password = "kh1234";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	//�޼��� ���� ����Ȯ��
	public boolean payment() { //������ ����� �ƴ��� �ȵƴ��� Ȯ���ϱ����� boolean���
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice(); /*cart�ȿ� ���� ���� �ݾ� �޼��� �߰��ϱ�*/
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			//������ ���� ���� �ܾ� ��������
			String userBalance = "SELECT balance FROM BANK WHERE account_name = '������'";
			PreparedStatement st = connection.prepareStatement(userBalance);
			ResultSet rs = st.executeQuery();
			//executeQuery : select���� �ַ� ����
			//executeUpdate : insert
			
			if(rs.next()) {
				double balance = rs.getDouble("balance"); //�׳� �ܾ� ��������
			
				//���࿡ �ܾ��� ��ٱ��� �Ѿ׺��� ���ٸ� 
				if(balance < cartTotalPrice) {
					System.out.println("�ܾ��� �����մϴ�.");
					return false;
				}
				//���� �������ִ� �ܾ׿��� ��ٱ��� �Ѿ��� ������Ѵ�.
				double newBalance = balance - cartTotalPrice;
				
				//�ܾ� ������Ʈ�ϱ�
				String updateBalance = "UPDATE BANK SET balance WHERE account_name = '������'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
			
				System.out.println("���� �Ϸ�!");
				System.out.println("���� �ܾ� : " + newBalance);
				
				return true;
			} else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
