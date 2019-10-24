import java.util.Scanner;

public class User {
    String name;
    Cart cart;
    String coupon;

    public User(final String name) {
        this.name = name;
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addProduct(final Product product) {
        cart.addToCart(product);
    }

    public void remove() {
        char ch = '.';
        do {
            System.out.println("Enter the product you want to remove");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(i + ") " + cart.getProduct(i));
        }
        int i = Integer.parseInt(scan.nextLine());

        }while (ch == '.');
    }

    public void getCouponCode() {
        System.out.println("Enter the coupon code:");
        while (true) {
            String temp = scan.nextLine();
            if (temp.equals("IND10") || temp.equals("IND20") ||
                temp.equals("IND30") || temp.equals("IND50")) {
                    cart.setCoupon(temp);
                    break;
                }
            if (temp.equals(".")) {
                break;
            }
            System.out.println("Enter valid coupon code else '.'");
        }
    }

    public void showItems() {
        cart.showCart();
    }
}
