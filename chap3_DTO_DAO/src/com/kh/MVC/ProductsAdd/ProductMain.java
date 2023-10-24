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
		
		//��� ��ǰ ����Ʈ ��������
		List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		//���� ���� ��� ��������
		Double totalPrice = controller.calculatorTotalPrice(products);
		view.showTotalPrice(totalPrice);

	}
	
	public void getcarts() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		//��ٱ��� ��ǰ ����Ʈ ��������
		List<ProductDTO> carts = controller.getCart();
		view.showCartList(carts);
		
		//��ٱ��� ��ǰ ���� �� ��
		double totalPrice = controller.calculatorCartPrice(carts);
		view.showTotalPrice(totalPrice);
	}
	
}
