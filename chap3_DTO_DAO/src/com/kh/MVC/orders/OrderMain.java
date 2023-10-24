package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//최종 실행
public class OrderMain {
	
	public static void main(String[] args) {

		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		//모든 주문 내역 리스트 가져오기
		List<OrderDTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		//최종 가격 계산 가져오기
		Double totalPrice = controller.calculatorTotalPrice(orders);
		view.showTotalPrice(totalPrice);
	}

}