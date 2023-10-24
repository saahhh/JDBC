package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}
	
	//�� ���� ����ϴ� �޼���
	public double calculatorTotalPrice(List<ProductDTO> products) {
		double totalPrice = 0;
		//double totalPrice = 0;�� ������
		//���� for���� Ȱ���Ͽ� ������ ������ ���̱� ������ 0���� ������
		for(ProductDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;		
	}
	
	//��� ��ǰ�� ����Ʈ
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
	
	
	//��ٱ��Ͽ� ��� �� ���� ���
	public double calculatorCartPrice(List<ProductDTO> carts) {
		double totalPrice = 0;
		for(ProductDTO totalP : carts) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	//��ٱ��Ͽ� ��� ��ǰ ����Ʈ
	public List<ProductDTO> getCart(){
		return dao.getCart();
	}
}
