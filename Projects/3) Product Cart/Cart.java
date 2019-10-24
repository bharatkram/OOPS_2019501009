public class Cart {

    Set<Product> productsTaken;
    int[] qtyOfProduct;
    int size;
    String coupon;

    Cart() {
        productsTaken = new Set<Product>(20);
        qtyOfProduct = new int[20];
        size = 0;
        coupon = ".";
    }

    public void setCoupon(final String c) {
        coupon = c;
    }

    public int size() {
        return size;
    }

    public void addToCart(final Product product) {
        if (productsTaken.add(product) == 1) {
            size++;
        }
        qtyOfProduct[productsTaken.indexOf(product)]++;
    }

    public Product getProduct(final int index) {
        return productsTaken.get(index);
    }

    public int getQuantity(final int i) {
        return qtyOfProduct[i];
    }

    public void removeFromCart(final Product product) {
        if (productsTaken.contains(product)) {
            if (qtyOfProduct[productsTaken.indexOf(product)] == 1) {
                productsTaken.remove(productsTaken.indexOf(product));
            } else {
                qtyOfProduct[productsTaken.indexOf(product)] -= 1;
            }
        }
    }

    public void showCart() {
        System.out.println("\n\nCart Details:\n");
        for (int i = 0; i < productsTaken.size(); i++) {
            System.out.println("Item: " + productsTaken.get(i).getName()
                    + " qty: " + qtyOfProduct[i] + " Price: "
                    + productsTaken.get(i).getPrice());
        }
    }

    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < productsTaken.size(); i++) {
            total += (productsTaken.get(i).getPrice() * qtyOfProduct[i]);
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
        if (productsTaken.size() == 0) {
            System.out.println("No products in cart.\nSee you next time.");
            return;
        }
        int total = 0;
        for (int i = 0; i < productsTaken.size(); i++) {
            total += qtyOfProduct[i] * (productsTaken.get(i).getPrice()
                    - productsTaken.get(i).getPrice() * applyCoupon());
            System.out.println(" Product: " + productsTaken.get(i).getName()
                    + " qty: " + qtyOfProduct[i] + " MRP: "
                    + productsTaken.get(i).getPrice() + " Discount: "
                    + productsTaken.get(i).getPrice() * applyCoupon()
                    + " Amount: " + (productsTaken.get(i).getPrice()
                    - productsTaken.get(i).getPrice() * applyCoupon())
                    * qtyOfProduct[i]);
        }
        System.out.println("total = " + total);
    }

}
