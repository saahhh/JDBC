package com.kh.MVC.ProductsAdd;

import java.util.List;

//dto - model - dao - view - controller - main
public class ProductView {
	public void showProductList(List<ProductDTO> products /*��ǰ ����Ʈ �Ķ���� �߰�*/) {
		for(ProductDTO p : products) { //p=product
			System.out.println("��ǰ�� : " + p.getProduct_name());
			System.out.println("���� : " + p.getPrice());
			System.out.println("=============================");
		}
	}	
	//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalprice) {
		System.out.println("�� �հ� : " + totalprice);
	}
	
	public void showCartList(List<ProductDTO> carts) {
		for(ProductDTO p : carts) {
			System.out.println("��ǰ�� : " + p.getProduct_name());
			System.out.println("��ǰ ���� : " + p.getPrice());
		}
		
	
	}
	
}
