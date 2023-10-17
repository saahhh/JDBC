package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
//		selectBank();
//		selectkhcafe();
//		selectIf();
		insertBank();
	}
		
	static void selectBank() {
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
		//								나의IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM bank ORDER BY 1";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery(); //ResultSet result = 결과들의 집합
			//result.next() : result 객체에서 다음 행(row)로 이동
			//다음행이 있으면 true를 반환, 그렇지 않으면 false를 반환한다.
			while(result.next()) {
				//khbank에 있는 bank 테이블 결과집합에서 account_id(열이름)를 가져옴
				int accountID = result.getInt("account_id"); //result set 결과 집합에서 보고 싶은 것만 가져와서 출력한 것
				//1. 함께 해보기 : accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. 함께 해보기 : branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransactionDate 가져오기
				Date lastTransactionDate = result.getDate("last_transaction_date");
				
				System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NUMBER : " + accountNumber + ", ACCOUNT_NAME : " + accountName + 
						", BALANCE : " + balance + ", BRANCH_NAME : " + branchName + ", LAST_TRANSACTION_DATE : " + lastTransactionDate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	static void selectkhcafe() {
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
				String driver = "oracle.jdbc.driver.OracleDriver";
				//2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
				//								나의IP주소:port번호
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khcafe";
				String password = "kh1234";
				Connection con = null;
				//select * from menu 작성해서 menu table 가져오기
				try {
					con = DriverManager.getConnection(url, user, password);
					System.out.println("데이터베이스 연결 성공");
					String selectQuery = "SELECT * FROM cafes ORDER BY 1";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result  = selectState.executeQuery();
					while(result.next()) {
						int cafe_id = result.getInt("CAFE_ID");
						String cname = result.getString("CNAME");
						String address = result.getString("ADDRESS");
						String phone_number = result.getString("PHONE_NUMBER");
						String operating_hours = result.getNString("OPERATING_HOURS");
						System.out.println("CAFE_ID : " + cafe_id + ", CAFENAME : " + cname + ", ADDRESS : " + address + ",PHONE_NUMBER : " + phone_number + ", OPERATING_HOURS : " + operating_hours);
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con = DriverManager.getConnection(url, user, password);
					String selectQuery = "SELECT * FROM menu";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
						int menu_id = result.getInt("MENU_ID");
						int cafe_id = result.getInt("CAFE_ID");
						String menu_name = result.getString("MENU_NAME");
						double price = result.getDouble("PRICE");
						String description = result.getString("DESCRIPTION");
						System.out.println("MENU_ID : " + menu_id + ", CAFE_ID : " + cafe_id + ", MENU_NAME : " + menu_name + ", PRICE : " + price + ", DESCRIPTION : " + description);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
	
	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //thin이 driver의 역할을 하기 때문에 String driver = "oracle.jdbc.driver.OracleDriver";가 없어도 되는 것
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//WHERE절 사용해서 조건 추가 //?를 넣어 target코드에서 숫자 바꾸도록
//			String selectQuery = "SELECT * FROM BANK WHERE account_id = ?";
//			String selectQuery = "SELECT * FROM BANK WHERE account_name = ?";
//			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?)"; 
//			String selectQuery = "SELECT * FROM BANK WHERE branch_name = ?";
			String selectQuery = "SELECT * FROM BANK WHERE account_id in (?,?,?)";
			
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//여기에 원하는 조건의 account_id 설정
//			int targetAID = 1;
//			String targetAN = "이지은";
//			int targetAN =1236777888;
//			String[] targetAN = {"1234567890","5555666777","3333444555"};
//			String[] targetBN = {"북쪽지점"};
			int[] targetAID = {1,2,3};
			
			
			//조건 설정
//			selectState.setInt(1, targetAID); //1은 자리값
//			selectState.setString(1, targetAN);
//			selectState.setInt(1, targetAN);

//			selectState.setString(1, targetAN[0]); 
//			selectState.setString(2, targetAN[1]);
//			selectState.setString(3, targetAN[2]); //인덱스 규칙 위반하지 않게 순서 맞춰서 써야함
			
			selectState.setInt(1, targetAID[0]);
			selectState.setInt(2, targetAID[1]);
			selectState.setInt(3, targetAID[2]);
			
			ResultSet result = selectState.executeQuery();
			
			//값 존재 여부
			if(!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없습니다.");
			}
			while (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + " ACCOUNT_NUMBER : " + b + " ACCOUNT_NAME : " + c + " BALANCE : " + d + 
						" BRANCH_NAME : " + e + " LAST_TRANSACTION_DATE : " + f);
			}
			if(!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없음"); //while문이 끝난 상태여서 출력되는 것이 당연하기 때문에 while 시작전에 넣어줘야한다.
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	static void insertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					 + "VALUES (?, ?, ?, ? ,? ,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "123451234");
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//
//else {
//	System.out.println("조건에 해당하는 데이터가 없습니다.");
//}

/*
String a = result.getString("열이름");
char[] charArray = 열이름.toCharArray();
for(char c : charArray) {
}
*/