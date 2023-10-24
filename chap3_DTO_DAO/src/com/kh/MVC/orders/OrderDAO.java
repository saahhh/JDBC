package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DB연결 후 slect 작성
public class OrderDAO {
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> orders = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int order_id = rs.getInt("order_id");
				int cafe_id = rs.getInt("cafe_id");
				int menu_id = rs.getInt("menu_id");
				Date order_date = rs.getDate("order_date");
				int quantity = rs.getInt("quantity");
				double total_price = rs.getDouble("total_price");
				String description = rs.getString("description");
				
				OrderDTO order = new OrderDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, description);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
}

