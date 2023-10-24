package com.kh.MVC.shopping;

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
		pm.getAll();
	}
	
	public void getAll() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		List<ProductDTO> products = controller.getAllProducts();
		
		Scanner sc = new Scanner(System.in);
		//����īƮ �ν��Ͻ� �����ڸ�
		ShoppingCart cart = new ShoppingCart();
		
		int choice = sc.nextInt();

		switch(choice) {
			case 1 :
				//��� ��ǰ ����Ʈ ��������
				//List<ProductDTO> products = controller.getAllProducts();
				view.showProductList(products);
		
			case 2 :
				//���� ���� ��� ��������
				Double totalPrice = controller.calculatorTotalPrice(products);
				view.showTotalPrice(totalPrice);
			case 3 :	
				//��ǰ �߰�
				System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���.");
				//��ǰ ���̵� �Է� �ޱ�
				int product_id = sc.nextInt();
				//���� for���� if���� Ȱ���ؼ� ��ǰ ���
				for(ProductDTO p : products) {
					if(p.getProduct_id() == product_id) {
						//īƮ�� �߰�
						cart.addCart(p);
						System.out.println(p.getProduct_name() + " ��ٱ��Ͽ� ��ҽ��ϴ�.");
						break;
					}
				}
			case 4 :	
				//����
				System.out.println("��ٱ��Ͽ��� ������ ��ǰ�� ID�� �Է��ϼ���.");
				int removeProductId = sc.nextInt();
				for(ProductDTO r : cart.getCartList()/*��ٱ��� ���*/) {
					cart.removeGoods(r);
					break;
				}
			case 5 : 
				//����
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				if(payResult) {
					//cart����
				}
				break;
				
			default : 
				System.out.println("�߸��� �����Դϴ�.");
		}

	}
	
}
