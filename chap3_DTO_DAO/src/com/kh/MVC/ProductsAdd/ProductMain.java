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

	/* public class ProductApp {
	
		    ProductDAO dao = new ProductDAO();
		    ProductController controller = new ProductController(dao);
		    ProductView view = new ProductView();

		    List<ProductDTO> products = controller.getAllProducts();
		   // view.showProductList(products);

		    Scanner scanner = new Scanner(System.in);
		    ShoppingCart cart = new ShoppingCart(); // ��ٱ��� ��ü ����

		    while (true) {

		        System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. ");
		        System.out.print("����Ϸ��� '0' �Է��մϴ�: ");
		        int productId = scanner.nextInt();

		        if (productId == 0) {
		            break;
		        }

		        for (ProductDTO product : products) {
		            if (product.getProduct_id() == productId) {
		                cart.addToCart(product); // ��ٱ��Ͽ� ��ǰ �߰�
		               
		                break;
		            }
		        }
		    }
		    double totalPrice = cart.calculateTotalPrice(); // �� ���� ���
		    view.showTotalPrice(totalPrice);
		}
	}
	*/

