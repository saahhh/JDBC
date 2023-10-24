package com.kh.MVC.shopping;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}
	
	//총 가격 계산하는 메서드
	public double calculatorTotalPrice(List<ProductDTO> products) {
		double totalPrice = 0;
		//double totalPrice = 0;인 이유는
		//향상된 for문을 활용하여 가격을 더해줄 것이기 때문에 0으로 지정함
		for(ProductDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;		
	}
	
	//모든 제품의 리스트
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
	
}