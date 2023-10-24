package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList 
	private List<ProductDTO> cartList; //=��ٱ��� ���
	
	//����īƮ ������
	public ShoppingCart() {
		cartList = new ArrayList<>();		
	}
	
	//��ٱ��� ��� �������� get�޼���
	public List<ProductDTO> getCartList() {
		return cartList;
	}
	
	//��ٱ��� ���� ���� �ݾ� �޼���
	public double cartTotalPrice() {
		double totalprice = 0;
		//���� for���� �̿��ؼ� ���� �߰�
		for(ProductDTO c : cartList) {
			totalprice += c.getPrice();
		}
		return totalprice;
	}
	
	//��ٱ��Ͽ� �߰��� �޼��� ����
	public void addCart(ProductDTO product /*�Ķ���� �� �߰�*/) {
		cartList.add(product);
		System.out.println(product.getProduct_name() + "��ٱ��Ͽ� �߰��߽��ϴ�.");
	}
	
	//��ٱ��Ͽ��� ������ �޼��� ����
	public void removeGoods(ProductDTO product) {
		if (cartList.remove(product)) {
			System.out.println("��ٱ��Ͽ��� ���������ϴ�.");
		} else {
			System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
		}
	}
}
