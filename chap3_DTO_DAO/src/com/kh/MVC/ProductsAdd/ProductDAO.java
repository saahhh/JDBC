package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public ProductDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM products");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String category = result.getString("category");
				Double price = result.getDouble("price");
				int stock_quantity = result.getInt("stock_quantity");
				
				ProductDTO product = new ProductDTO(product_id, product_name, category, price, stock_quantity);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public List<ProductDTO> getCart() {
		List<ProductDTO> carts = new ArrayList<>();
	
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUserName = "khcafe";
	String dbPassWord = "kh1234";
	
	try {
		Connection con = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("product ID�� �Է����ּ���.");
			System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
			String input = sc.nextLine();
	
			if("e".equalsIgnoreCase(input)) {
				System.out.println("��ٱ��� ��� �Ϸ�");
				break;
			}
			
			int product_id = Integer.parseInt(input);
			String sql = "SELECT product_name, price FROM products WHERE product_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, product_id);
			
			ResultSet rs = st.executeQuery();
			//if�� while��
			while(rs.next()) {
				String prduct_name = rs.getString("product_name");
				double price = rs.getDouble("price");
				
				System.out.println("��ǰ�� : " + rs.getString("product_name"));
				System.out.println("���� : " + rs.getDouble("price"));
				
				ProductDTO cart = new ProductDTO(product_id, prduct_name, price); //��ǰ��, ���� �߰�
				carts.add(cart);

			}

		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return carts;
	
}
	
}

