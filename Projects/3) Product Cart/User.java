import java.util.Scanner;

public class User {
    String name;
    Cart cart;
    String coupon;
    Scanner scan;

    public User(final String name) {
        this.name = name;
        cart = new Cart();
        scan = new Scanner(System.in);
    }

    public void getcouponCode() {
        System.out.println("Enter the coupon code:");
        while (true) {
            String temp = scan.nextLine();
            if (temp.equals("IND10") || temp.equals("IND20") ||
                temp.equals("IND30") || temp.equals("IND50")) {
                    cart.setCoupon(coupon);
                    break;
                }
            if (temp.equals(".")) {
                break;
            }
            System.out.println("Enter valid coupon code else '.'");
        }
    }

    // System.out.println("Enter the coupon code if any or '.': ");
    //     do {
    //         discount = applyCoupon(scan.nextLine());
    //     } while (discount < 0);
}