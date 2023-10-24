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
	
	//메서드 만들어서 결제확인
	public boolean payment() { //결제가 제대로 됐는지 안됐는지 확인하기위해 boolean사용
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice(); /*cart안에 최종 결제 금액 메서드 추가하기*/
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			//가나다 씨의 계좌 잔액 가져오기
			String userBalance = "SELECT balance FROM BANK WHERE account_name = '가나다'";
			PreparedStatement st = connection.prepareStatement(userBalance);
			ResultSet rs = st.executeQuery();
			//executeQuery : select에서 주로 쓰임
			//executeUpdate : insert
			
			if(rs.next()) {
				double balance = rs.getDouble("balance"); //그냥 잔액 가져오기
			
				//만약에 잔액이 장바구니 총액보다 적다면 
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				//내가 가지고있는 잔액에서 장바구니 총액을 빼줘야한다.
				double newBalance = balance - cartTotalPrice;
				
				//잔액 업데이트하기
				String updateBalance = "UPDATE BANK SET balance WHERE account_name = '가나다'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
			
				System.out.println("결제 완료!");
				System.out.println("남은 잔액 : " + newBalance);
				
				return true;
			} else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
