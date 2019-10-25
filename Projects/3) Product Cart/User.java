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
        Scanner scanr = new Scanner(System.in);
        char ch = ' ';
        do {
            System.out.println("Enter the product you want to remove");
            for (int i = 0; i < cart.productsTaken().size(); i++) {
                System.out.println((i + 1) + ") " + cart.getProduct(i).getName()
                        + "\tqty: " + cart.getQuantity(i));
        }
        System.out.println("Or press '0' to exit");
        int i = Integer.parseInt(scanr.nextLine());

        if (i != 0){
            cart.removeFromCart(cart.getProduct(i - 1));
        }

        System.out.println("Do you want to remove anything else? y/n ");
        ch = scanr.nextLine().charAt(0);

        } while (ch == 'y');
    }

    public void getCouponCode() {
        Scanner scangcc = new Scanner(System.in);
        System.out.println("Enter the coupon code:");
        while (true) {
            String temp = scangcc.nextLine();
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
        // scangcc.close();
    }

    public void showItems() {
        cart.showCart();
    }
}
