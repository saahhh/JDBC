package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) { 
		ProductMain pm = new ProductMain();
		//pm.getAll();
		pm.getcarts();
	}
	
	public void getAll() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		//모든 제품 리스트 가져오기
		List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		//최종 가격 계산 가져오기
		Double totalPrice = controller.calculatorTotalPrice(products);
		view.showTotalPrice(totalPrice);

	}
	
	public void getcarts() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		//장바구니 제품 리스트 가져오기
		List<ProductDTO> carts = controller.getCart();
		view.showCartList(carts);
		
		//장바구니 제품 가격 총 합
		double totalPrice = controller.calculatorCartPrice(carts);
		view.showTotalPrice(totalPrice);
	}
	
}
