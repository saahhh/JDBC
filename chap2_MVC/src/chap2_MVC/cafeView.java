package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel이라는 클래스를 가지고 오기위해 멤버변수로 카페 모델을 추가한다
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname, address, phone_number, operationg_hours
	public void addCafename() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명 : " );
		String name = sc.nextLine();
		System.out.println("카페 주소 : ");
		String address = sc.nextLine();
		System.out.println("카페 연락처 : ");
		String phone_number = sc.nextLine();
		System.out.println("카페 운영시간 : ");
		String operationg_hours = sc.nextLine();
		
		//cafeModel에서 insertCafe라는 메서드를 가지고 와야한다
		model.insertCafe(name, address, phone_number, operationg_hours);
		System.out.println("카페가 성공적으로 추가되었습니다.");		
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");
		System.out.println("카페 ID : ");
		int cafe_id = sc.nextInt();
		System.out.println("메뉴 ID : ");
		int menu_id = sc.nextInt();
		System.out.println("수정할 메뉴 설명 : ");
		String description = sc.nextLine();

		//model에 있는 UpdateMenu를 가지고와서 사용자가 작성한 수정 내용 추가하기
		model.UpdateMenu(cafe_id, menu_id, description);
		System.out.println("메뉴 설명이 업데이트되었습니다.");
	}
	
	public void updateCafe(){ //사용자가 운영시간 수정할 화면 Scanner이용해서 만들기
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 운영시간을 업데이트하세요.");
		/*
		nextInt() 숫자입력받는메서드
 		nextLine() 에는 모든 버퍼가 끝났으니 입력할 시간 없이 넘어간다는 기능까지 포함되어 있는 것
 		next()는 nextLine()대신 한 줄만 넘어가고 입력가능
 		*/
		System.out.println("카페 ID : ");
		int cafe_id = sc.nextInt();	
		System.out.println("수정할 운영시간 : ");
		String operating_hours = sc.next(); //nextLine()대신 next()입력
		
		model.UpdateCafe(cafe_id, operating_hours); //설정한 파라미터 값에 맞춰 스캐너 값 넣기
		System.out.println("카페 운영 시간이 변경되었습니다.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.println("삭제할 카페 ID를 입력하세요.");
		int cafe_id = Integer.parseInt(sc.next()); //
		//int cafeId_other = sc.nextInt();

		model.deleteCafe(cafe_id);
		System.out.println(cafe_id + " 카페가 삭제되었습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제하겠습니다.");
		System.out.println("삭제할 메뉴ID를 입력하세요.");
		int menu_id = Integer.parseInt(sc.next());
		
		model.deleteMenu(menu_id);
		System.out.println("메뉴가 삭제 되었습니다.");
	}
	
}
