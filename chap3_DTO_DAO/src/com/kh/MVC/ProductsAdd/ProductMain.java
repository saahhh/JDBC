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

	/* public class ProductApp {
	
		    ProductDAO dao = new ProductDAO();
		    ProductController controller = new ProductController(dao);
		    ProductView view = new ProductView();

		    List<ProductDTO> products = controller.getAllProducts();
		   // view.showProductList(products);

		    Scanner scanner = new Scanner(System.in);
		    ShoppingCart cart = new ShoppingCart(); // 장바구니 객체 생성

		    while (true) {

		        System.out.println("장바구니에 추가할 제품의 ID를 입력하세요. ");
		        System.out.print("계산하려면 '0' 입력합니다: ");
		        int productId = scanner.nextInt();

		        if (productId == 0) {
		            break;
		        }

		        for (ProductDTO product : products) {
		            if (product.getProduct_id() == productId) {
		                cart.addToCart(product); // 장바구니에 제품 추가
		               
		                break;
		            }
		        }
		    }
		    double totalPrice = cart.calculateTotalPrice(); // 총 가격 계산
		    view.showTotalPrice(totalPrice);
		}
	}
	*/

