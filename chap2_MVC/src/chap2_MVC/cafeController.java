package chap2_MVC;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//model�� view�� ������ �� ������ �����
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	
}

