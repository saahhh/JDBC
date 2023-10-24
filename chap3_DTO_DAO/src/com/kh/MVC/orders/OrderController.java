package com.kh.MVC.orders;

import java.util.List;

//DAO View 가격 계산 메서드
public class OrderController {
	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	
	//총 가격 계산하는 메서드
	public double calculatorTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalO : orders) {
			totalPrice += totalO.getTotal_price();
		}
		return totalPrice;
	}
	
	//모든 제품의 리스트
	public List<OrderDTO> getAllOrders(){
		return dao.getAllOrders();
	}

}
