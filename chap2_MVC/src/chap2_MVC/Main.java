package chap2_MVC;

public class Main {
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		//controller�� ���� ������ �� �ְ� �������
		//cafeController controller = new cafeController(model, view);
	
		//view.addCafename();
		//view.updateMenu();
		//view.updateCafe();
		//view.deleteCafe();
		//view.deleteMenu();
		
		cafeController controller = new cafeController(model, view);
		controller.run();
		
	}
	
}
