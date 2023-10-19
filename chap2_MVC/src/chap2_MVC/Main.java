package chap2_MVC;

public class Main {
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		//controller를 만들어서 실행할 수 있게 해줘야함
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
