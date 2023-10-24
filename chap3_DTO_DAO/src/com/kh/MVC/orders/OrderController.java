package com.kh.MVC.orders;

import java.util.List;

//DAO View ���� ��� �޼���
public class OrderController {
	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	
	//�� ���� ����ϴ� �޼���
	public double calculatorTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalO : orders) {
			totalPrice += totalO.getTotal_price();
		}
		return totalPrice;
	}
	
	//��� ��ǰ�� ����Ʈ
	public List<OrderDTO> getAllOrders(){
		return dao.getAllOrders();
	}

}
