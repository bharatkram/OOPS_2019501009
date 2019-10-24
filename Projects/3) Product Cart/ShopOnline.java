import java.util.Scanner;

public class ShopOnline {

    ProductCatalog[] company;
    User user;
    Scanner scan;

    ShopOnline(final String name) {
        company = new ProductCatalog[3];
        user = new User(name);
        scan = new Scanner(System.in);
    }

    public void setCatalogs() {

        company[0] = new ProductCatalog("Apple");
        
        company[0].addProductToCatalog(new Product(101, "phone", 5, 50000));
        company[0].addProductToCatalog(new Product(102, "charger", 10, 1000));
        company[0].addProductToCatalog(new Product(103, "earphones", 10, 2000));
        company[0].addProductToCatalog(new Product(104, "cover1", 20, 150));
        company[0].addProductToCatalog(new Product(105, "cover2", 20, 500));
        company[0].addProductToCatalog(new Product(106, "screen guard", 20, 50));

        // company[0].showCatalog();

        company[1] = new ProductCatalog("Allen Solly");

        company[1].addProductToCatalog(new Product(201, "Shirt", 20, 2500));
        company[1].addProductToCatalog(new Product(202, "T-Shirt", 20, 1000));
        company[1].addProductToCatalog(new Product(203, "Pant", 20, 2000));
        company[1].addProductToCatalog(new Product(204, "Jeans", 20, 1500));
        company[1].addProductToCatalog(new Product(205, "Pyjamas", 20, 1000));
        company[1].addProductToCatalog(new Product(206, "Shorts", 20, 500));

        // company[1].showCatalog();

        company[2] = new ProductCatalog("Kitchen Ware");

        company[2].addProductToCatalog(new Product(301, "Pan", 20, 500));
        company[2].addProductToCatalog(new Product(302, "Knife", 20, 100));
        company[2].addProductToCatalog(new Product(303, "Peeler", 20, 200));
        company[2].addProductToCatalog(new Product(304, "Cooker", 20, 150));
        company[2].addProductToCatalog(new Product(305, "Serving Spoon", 50, 100));
        company[2].addProductToCatalog(new Product(306, "Plates(12)", 10, 500));

        // company[2].showCatalog();

    }

    public void categoryMenu() {
        int choice = 0;
        while (true) {
            try {
                System.out.println("Enter the category you choose:\n1) Mobiles"
                    + "\n2) Clothes\n3) Kitchen\n4) Exit");
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid input.");
            }

            switch(choice) {
                case 1 :company[choice -1].showCatalog();
                        chosen(choice - 1);
                        break;
                case 2 :company[choice -1].showCatalog();
                        chosen(choice - 1);
                        break;
                case 3 :company[choice -1].showCatalog();
                        chosen(choice - 1);
                        break;
                case 4 :return;
                default:break;
            }
        }
    }

    public void chosen(final int choice) {
        while (true) {
            System.out.println("Enter the product to be added to cart:\n'.'to exit");
            String ch = scan.nextLine();
            if (ch.charAt(0) == '.') {
                return;
            }
            Product prod = company[choice].get(Integer.parseInt(ch) - 1);
            if (prod != null) {
                user.addProduct(prod);
            } else {
                System.out.println("Enter a valid choice.");
            }
        }
    }

    public static void main(final String[] args) {
        Cart finalCart;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the user.");
        ShopOnline s = new ShopOnline(scan.nextLine());

        while (true) {
            s.setCatalogs();

            s.categoryMenu();

            s.user.getCouponCode();

            s.user.showItems();

            System.out.println("Do you want to remove any item from your cart?");
            if (scan.nextLine().charAt(0) == 'y') {
                if (s.user.getCart().size() == 0) {
                    System.out.println("No items in cart");
                } else {
                    s.user.remove();
                }
            }

            finalCart = s.user.getCart();

            System.out.println("Do you want to continue?\nPress 'n' to exit:");
            if (scan.nextLine().charAt(0) == 'n') {
                break;
            }
        }
        
        finalCart.printInvoice();
    }
}
