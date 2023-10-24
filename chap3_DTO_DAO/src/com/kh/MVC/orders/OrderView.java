package com.kh.MVC.orders;

import java.util.List;

//보여지는 화면 출력
public class OrderView {
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("주문 번호 : " + o.getOrder_id());
			System.out.println("주문 날짜 : " + o.getOrder_date());
			System.out.println("주문 수량 : " + o.getQuantity());
			System.out.println("총 가격 : " + o.getTotal_price());
			System.out.println("================================");
		}
	}
	
	//주문의 총 가격 메서드
	public void showTotalPrice(double totalprice) {
		System.out.println("총 가격 : " + totalprice);		
	}
	
}
