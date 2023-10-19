package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//model�� view�� ������ �� ������ �����
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			Scanner sc = new Scanner(System.in);
			//������ ��ȣ ��� �޼���� �Է�
			System.out.println("���ϴ� �۾��� �������ּ���.");
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴� ���� �߰�");
			System.out.println("3. ī�� ��ð� ����");
			System.out.println("4. �޴� ���� ����");
			System.out.println("5. ī�� ���� ����");
			System.out.println("6. ī�� �޴� ����");
			System.out.println("7. ����");
			
			int choice = sc.nextInt();
			
			switch (choice) {
				case 1 :
					view.addCafename();
					break;
				case 2 :
					view.updateMenu();
					break;
				case 3 : 
					view.updateCafe();
					break;
				case 4 : 
					view.updateMenu();
					break;
				case 5 : 
					view.deleteCafe();
					break;
				case 6 :
					view.updateMenu();
					break;
				case 7 : 
					System.out.println("���α׷��� �����մϴ�.");
					isTrue = false;
					break;
				default : 
					System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���.");
			}
			
		}
	
	}
	
}

