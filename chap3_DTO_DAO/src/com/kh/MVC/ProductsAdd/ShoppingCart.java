package com.kh.MVC.ProductsAdd;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
//��ٱ��� ��� ���
public class ShoppingCart { 
    private List<ProductDTO> cartContents;

    public ShoppingCart() {
        cartContents = new ArrayList<>();
    }

    public void addToCart(ProductDTO product) {
        cartContents.add(product);
        System.out.println(product.getProduct_name() + "��(��) ��ٱ��Ͽ� �߰��߽��ϴ�.");
    }

    public void removeFromCart(ProductDTO product) {
        if (cartContents.remove(product)) {
            System.out.println(product.getProduct_name() + "��(��) ��ٱ��Ͽ��� �����߽��ϴ�.");
        } else {
            System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
        }
    }

    public List<ProductDTO> getCartContents() {
        return cartContents;
    }

    public void showCartContents() {
        System.out.println("��ٱ��� ���:");
        for (ProductDTO product : cartContents) {
            System.out.println("��ǰ��: " + product.getProduct_name() + ", ����: " + product.getPrice());
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
        System.out.println("��ٱ��ϸ� ������ϴ�.");
    }
    
}

/* 
public class ProductApp { //shoppingcart �� main
	public static void main(String[] args) {
	    ProductDAO dao = new ProductDAO();
	    ProductController controller = new ProductController(dao);
	    ProductView view = new ProductView();

	    List<ProductDTO> products = controller.getAllProducts();
	   // view.showProductList(products);

	    Scanner scanner = new Scanner(System.in);
	    ShoppingCart cart = new ShoppingCart(); // ��ٱ��� ��ü ����

	    while (true) {

	        System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. ");
	        System.out.print("����Ϸ��� '0' �Է��մϴ�: ");
	        int productId = scanner.nextInt();

	        if (productId == 0) {
	            break;
	        }

	        for (ProductDTO product : products) {
	            if (product.getProduct_id() == productId) {
	                cart.addToCart(product); // ��ٱ��Ͽ� ��ǰ �߰�
	               
	                break;
	            }
	        }

	    }

	    double totalPrice = cart.calculateTotalPrice(); // �� ���� ���
	    view.showTotalPrice(totalPrice);

	   
	}

}

*/

