package com.kh.MVC.orders;

import java.util.List;

//�������� ȭ�� ���
public class OrderView {
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("�ֹ� ��ȣ : " + o.getOrder_id());
			System.out.println("�ֹ� ��¥ : " + o.getOrder_date());
			System.out.println("�ֹ� ���� : " + o.getQuantity());
			System.out.println("�� ���� : " + o.getTotal_price());
			System.out.println("================================");
		}
	}
	
	//�ֹ��� �� ���� �޼���
	public void showTotalPrice(double totalprice) {
		System.out.println("�� ���� : " + totalprice);		
	}
	
}
