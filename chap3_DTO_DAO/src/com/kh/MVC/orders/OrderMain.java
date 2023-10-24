package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//���� ����
public class OrderMain {
	
	public static void main(String[] args) {

		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		//��� �ֹ� ���� ����Ʈ ��������
		List<OrderDTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		//���� ���� ��� ��������
		Double totalPrice = controller.calculatorTotalPrice(orders);
		view.showTotalPrice(totalPrice);
	}

}