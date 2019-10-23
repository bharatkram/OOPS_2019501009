import java.util.Scanner;

public class Cart {

    Scanner scan;
    Product[] productsTaken;
    int[] qtyOfProduct;
    int size;
    String coupon;

    Cart() {
        scan = new Scanner(System.in);
        productsTaken = new Product[20];
        qtyOfProduct = new int[20];
        size = 0;
    }

    public void setCoupon(final String coupon) {
        this.coupon = coupon;
    }

    public void addToCart(final Product product) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (product.getName().equals(productsTaken[i].getName())) {
                flag = false;
                qtyOfProduct[i]++;
            }
        }
        if (flag) {
            productsTaken[size] = product;
            qtyOfProduct[size] += 1;
            size++;
        }
    }

    public void removeFromCart(final Product product) {
        boolean flag = true;
        int pos = size;
        int qty = 0;
        for (int i = 0; i < size; i++) {
            if (product.getName().equals(productsTaken[i].getName())) {
                flag = false;
                if (qtyOfProduct[i] > 1) {
                    while (qty > qtyOfProduct[i]) {
                        System.out.println("enter the qty to be removed: ");
                        qty = Integer.parseInt(scan.nextLine());
                    }
                    qtyOfProduct[i] -= qty;
                } else {
                    qtyOfProduct[i] -= 1;
                }
                if (qtyOfProduct[i] == 0) {
                    pos = i;
                }
            }
        }
        for (int i = pos; i < size; i++) {
            productsTaken[i] = productsTaken[i + 1];
            qtyOfProduct[i] = qtyOfProduct[i + 1];
        }
        if (!flag) {
            size--;
        }
    }

    public void showCart() {
        for (int i = 0; i < size; i++) {
            System.out.println("Item: " + productsTaken[i].getName()
                    + "qty: " + qtyOfProduct[i] + "Price: "
                    + productsTaken[i].getPrice());
        }
    }

    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += (productsTaken[i].getPrice() * qtyOfProduct[i]);
        }
        return total;
    }

    public double getPayableAmount() {
        double amount = getTotalAmount();
        double discount = applyCoupon();
        return 1.15 * (amount - amount * discount);
    }

    public double applyCoupon() {
        if (coupon.equals(".")) {
                return 0;
        } else if (coupon.equals("IND10")) {
            return 0.1;
        } else if (coupon.equals("IND20")) {
            return 0.2;
        } else if (coupon.equals("IND30")) {
            return 0.3;
        } else if (coupon.equals("IND50")) {
            return 0.5;
        }
        return -1;
    }

    public void printInvoice() {
        for (int i = 0; i < size; i++) {
            System.out.println("Product: " + productsTaken[i]
                    + "qty: " + qtyOfProduct[i] + "MRP: "
                    + productsTaken[i].getPrice() + "Discount: "
                    + productsTaken[i].getPrice() * applyCoupon()
                    + "Amount: " + (productsTaken[i].getPrice()
                    - productsTaken[i].getPrice() * applyCoupon()));
        }
    }

}
