package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
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
