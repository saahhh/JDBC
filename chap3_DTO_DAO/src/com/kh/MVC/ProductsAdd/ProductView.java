package com.kh.MVC.ProductsAdd;

import java.util.List;

//dto - model - dao - view - controller - main
public class ProductView {
	public void showProductList(List<ProductDTO> products /*제품 리스트 파라미터 추가*/) {
		for(ProductDTO p : products) { //p=product
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("가격 : " + p.getPrice());
			System.out.println("=============================");
		}
	}	
	//제품 최종 가격 메서드
	public void showTotalPrice(double totalprice) {
		System.out.println("총 합계 : " + totalprice);
	}
	
	public void showCartList(List<ProductDTO> carts) {
		for(ProductDTO p : carts) {
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("제품 가격 : " + p.getPrice());
		}
		
	
	}
	
}
