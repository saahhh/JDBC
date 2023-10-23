package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.selectAll();
		//um.insertRun();
		um.selectScanner();
	}
	
	//public boolean idTrue = checkId(userId);
	public boolean idTrue = checkId(userId) {
		//1.DB����
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		//2.SQL
		Connection con = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		Scanner sc = new Scanner(System.in);
		String sql = "SELECT * FROM userinfo WHERE user_id = ?";
		//3.IFȰ���ؼ� Result.next()
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet result = st.executeQuery();
			if (result.next()) {
				
			} else {
				
			} return > 0;
		//return > 0 1�̻��̸� ��ġ
	}
	
	public void selectScanner() {
		//1. DB���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID�� �Է����ּ���.");
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
				String input = sc.nextLine();
				
				//���࿡ e�� �Է��ߴٸ�
				//if ("e" == input || "E" == input) {
				if("e".equalsIgnoreCase(input)) {
					System.out.println("����");
					break; //break�� ������ ������� ����, �����ϰڽ��ϴ� �� ��µ�
				}
					int userId = Integer.parseInt(input); //����ȯ�� ���־� �ڵ���̸� �����Ŵ
					String email = sc.next();
					//select�� ����ϱ�
					String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND email = ?";
					PreparedStatement st = cc.prepareStatement(sql);
					st.setInt(1, userId);
					st.setString(2, email);
					
					ResultSet rs = st.executeQuery();
					
					//selectOne if
						if(rs.next()) {
							System.out.println("user ID : " + rs.getInt("user_id"));
							System.out.println("userName : " + rs.getString("user_name"));
							System.out.println("Email : " + rs.getString("email"));
							System.out.println("Registration Date : " + rs.getDate("reg_Date"));
							System.out.println();
						} else {
							//boolean ID or Email �� �ϳ��� ��ġ���� �ʴ� ����� ó�����
							boolean idTrue = checkId(userId);/*���̵� ��ġ�ϴ��� Ȯ���ϴ� �޼���(user_id);*/
							boolean emailTrue = checkEmail(userEmail); /*�̸�  �� ��ġ�ϴ��� Ȯ���ϴ� �޼���(userEmail);*/
							
							 if (!idTrue && emailTrue) {
								 System.out.println("��ġ�ϴ� User ID �Դϴ�.");
								 System.out.println();
							} else if (idTrue && emailTrue) { 
								 System.out.println("��ġ�ϴ� User Email �Դϴ�.");
								 System.out.println();
							} else {
								System.out.println("��ġ�ϴ� User ID�� emil�� ã�� �� �����ϴ�.");
								System.out.println();
							}
					
						}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	

		}
	
	public void selectAll() {
		//1. DB���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
				System.out.println("user ID : " + u.getUserId());
				System.out.println("user Name : " + u.getUserName());
				System.out.println("user Email : " + u.getEmail());
				System.out.println("Registration Date : " + u.getRegDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertRun() {
		//1. DB���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
			try {			
				Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
				UserDAO userDao = new UserDAO(connection);
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("User ID : ");
				int userId = sc.nextInt();
				
				System.out.println("���̵� �Է����ּ��� : ");
				String userName = sc.next();
				
				System.out.println("ȸ�������� ���� �� �������ϴ�.");
				System.out.println("���������� �̸����� �ۼ����ּ���. : ");
				String email = sc.next();
				
				Date regDate = new Date(); //(util import) ���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
				
				//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
				UserVO newUser = new UserVO();
				newUser.setUserId(userId);
				newUser.setUserName(userName);
				newUser.setEmail(email);
				newUser.setRegDate(regDate);
				
				//�����Ͱ� ���������� ������ boolean���� Ȯ�����ش�
				
				if(userDao.createUser(newUser)) { //true
					System.out.println("������ ���������� ��ϵǾ����ϴ�.");
				} else {
					System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
				}
				//���� �ݱ�
				connection.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}
