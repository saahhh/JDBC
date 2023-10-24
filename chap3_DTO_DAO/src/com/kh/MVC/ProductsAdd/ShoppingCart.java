package com.kh.MVC.ProductsAdd;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
//장바구니 담기 답안
public class ShoppingCart { 
    private List<ProductDTO> cartContents;

    public ShoppingCart() {
        cartContents = new ArrayList<>();
    }

    public void addToCart(ProductDTO product) {
        cartContents.add(product);
        System.out.println(product.getProduct_name() + "을(를) 장바구니에 추가했습니다.");
    }

    public void removeFromCart(ProductDTO product) {
        if (cartContents.remove(product)) {
            System.out.println(product.getProduct_name() + "을(를) 장바구니에서 제거했습니다.");
        } else {
            System.out.println("장바구니에 해당 제품이 없습니다.");
        }
    }

    public List<ProductDTO> getCartContents() {
        return cartContents;
    }

    public void showCartContents() {
        System.out.println("장바구니 목록:");
        for (ProductDTO product : cartContents) {
            System.out.println("제품명: " + product.getProduct_name() + ", 가격: " + product.getPrice());
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (ProductDTO product : cartContents) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
    public void clearCart() {
        cartContents.clear();
        System.out.println("장바구니를 비웠습니다.");
    }
    
}

/* 
public class ProductApp { //shoppingcart 의 main
	public static void main(String[] args) {
	    ProductDAO dao = new ProductDAO();
	    ProductController controller = new ProductController(dao);
	    ProductView view = new ProductView();

	    List<ProductDTO> products = controller.getAllProducts();
	   // view.showProductList(products);

	    Scanner scanner = new Scanner(System.in);
	    ShoppingCart cart = new ShoppingCart(); // 장바구니 객체 생성

	    while (true) {

	        System.out.println("장바구니에 추가할 제품의 ID를 입력하세요. ");
	        System.out.print("계산하려면 '0' 입력합니다: ");
	        int productId = scanner.nextInt();

	        if (productId == 0) {
	            break;
	        }

	        for (ProductDTO product : products) {
	            if (product.getProduct_id() == productId) {
	                cart.addToCart(product); // 장바구니에 제품 추가
	               
	                break;
	            }
	        }

	    }

	    double totalPrice = cart.calculateTotalPrice(); // 총 가격 계산
	    view.showTotalPrice(totalPrice);

	   
	}

}

*/

