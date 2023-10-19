package chap2_MVC;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//model과 view를 가지고 올 생성자 만들기
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	
}

