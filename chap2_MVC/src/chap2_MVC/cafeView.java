package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel�̶�� Ŭ������ ������ �������� ��������� ī�� ���� �߰��Ѵ�
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname, address, phone_number, operationg_hours
	public void addCafename() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ�� : " );
		String name = sc.nextLine();
		System.out.println("ī�� �ּ� : ");
		String address = sc.nextLine();
		System.out.println("ī�� ����ó : ");
		String phone_number = sc.nextLine();
		System.out.println("ī�� ��ð� : ");
		String operationg_hours = sc.nextLine();
		
		//cafeModel���� insertCafe��� �޼��带 ������ �;��Ѵ�
		model.insertCafe(name, address, phone_number, operationg_hours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");		
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		System.out.println("ī�� ID : ");
		int cafe_id = sc.nextInt();
		System.out.println("�޴� ID : ");
		int menu_id = sc.nextInt();
		System.out.println("������ �޴� ���� : ");
		String description = sc.nextLine();

		//model�� �ִ� UpdateMenu�� ������ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.UpdateMenu(cafe_id, menu_id, description);
		System.out.println("�޴� ������ ������Ʈ�Ǿ����ϴ�.");
	}
	
	public void updateCafe(){ //����ڰ� ��ð� ������ ȭ�� Scanner�̿��ؼ� �����
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ��ð��� ������Ʈ�ϼ���.");
		/*
		nextInt() �����Է¹޴¸޼���
 		nextLine() ���� ��� ���۰� �������� �Է��� �ð� ���� �Ѿ�ٴ� ��ɱ��� ���ԵǾ� �ִ� ��
 		next()�� nextLine()��� �� �ٸ� �Ѿ�� �Է°���
 		*/
		System.out.println("ī�� ID : ");
		int cafe_id = sc.nextInt();	
		System.out.println("������ ��ð� : ");
		String operating_hours = sc.next(); //nextLine()��� next()�Է�
		
		model.UpdateCafe(cafe_id, operating_hours); //������ �Ķ���� ���� ���� ��ĳ�� �� �ֱ�
		System.out.println("ī�� � �ð��� ����Ǿ����ϴ�.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī�� ID�� �Է��ϼ���.");
		int cafe_id = Integer.parseInt(sc.next()); //
		//int cafeId_other = sc.nextInt();

		model.deleteCafe(cafe_id);
		System.out.println(cafe_id + " ī�䰡 �����Ǿ����ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϰڽ��ϴ�.");
		System.out.println("������ �޴�ID�� �Է��ϼ���.");
		int menu_id = Integer.parseInt(sc.next());
		
		model.deleteMenu(menu_id);
		System.out.println("�޴��� ���� �Ǿ����ϴ�.");
	}
	
}
