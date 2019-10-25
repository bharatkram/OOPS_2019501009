public class Cart {

    /**
     * the arraylist of products that have been added to cart.
     */
    private Set<Product> productsTaken;

    /**
     * the quantity of each product being added to cart.
     */
    private int[] qtyOfProduct;

    /**
     * the number of products present in the cart.
     */
    private int size;

    /**
     * the coupon code the user would like to use.
     */
    private String coupon;

    Cart() {
        productsTaken = new Set<Product>(20);
        qtyOfProduct = new int[20];
        size = 0;
        coupon = ".";
    }

    /**
     * function to return the products present in the cart.
     *
     * @return the products present in the cart.
     */
    public Set<Product> productsTaken() {
        return productsTaken;
    }

    /**
     * function to set the coupon code.
     *
     * @param c the coupon code with user in string format.
     */
    public void setCoupon(final String c) {
        coupon = c;
    }

    /**
     * function to return the size of cart.
     *
     * @return the number of items in cart.
     */
    public int size() {
        return size;
    }

    /**
     * function to add a product to the cart.
     *
     * @param product the product that has to be added.
     */
    public void addToCart(final Product product) {
        if (productsTaken.add(product) == 1) {
            size++;
        }
        qtyOfProduct[productsTaken.indexOf(product)]++;
    }

    /**
     * function to get the product in cart at a particular index.
     *
     * @param index the position of product in cart.
     * @return the product at the required pos.
     */
    public Product getProduct(final int index) {
        return productsTaken.get(index);
    }

    /**
     * function to get the quantity of product at a particular index.
     *
     * @param i the position of the product.
     * @return the quantity of the product.
     */
    public int getQuantity(final int i) {
        return qtyOfProduct[i];
    }

    /**
     * function to remove the product from the cart.
     *
     * @param product the product that is to be removed.
     */
    public void removeFromCart(final Product product) {
        if (productsTaken.contains(product)) {
            if (qtyOfProduct[productsTaken.indexOf(product)] == 1) {
                productsTaken.remove(productsTaken.indexOf(product));
            } else {
                qtyOfProduct[productsTaken.indexOf(product)] -= 1;
            }
        }
    }

    /**
     * function to print the contents of the cart.
     */
    public void showCart() {
        System.out.println("\n\nCart Details:\n");
        for (int i = 0; i < productsTaken.size(); i++) {
            System.out.println("Item: " + productsTaken.get(i).getName()
                    + " qty: " + qtyOfProduct[i] + " Price: "
                    + productsTaken.get(i).getPrice());
        }
    }

    /**
     * function to get the total amount of the products in cart.
     *
     * @return the total amount.
     */
    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < productsTaken.size(); i++) {
            total += (productsTaken.get(i).getPrice() * qtyOfProduct[i]);
        }
        return total;
    }

    /**
     * function to get the amount to be paid after applying the
     * respective discount from the coupon code.
     *
     * @return the amount to be paid.
     */
    public double getPayableAmount() {
        double amount = getTotalAmount();
        double discount = applyCoupon();
        return 1.15 * (amount - amount * discount);
    }

    /**
     * function to apply the coupon code.
     *
     * @return the percentage of discount by the coupon.
     */
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

    /**
     * function to print the invoice or the bill for the selected products.
     */
    public void printInvoice() {
        if (productsTaken.size() == 0) {
            System.out.println("No products in cart.\nSee you next time.");
            return;
        }
        int total = 0;
        for (int i = 0; i < productsTaken.size(); i++) {
            total += qtyOfProduct[i] * (productsTaken.get(i).getPrice()
                    - productsTaken.get(i).getPrice() * applyCoupon());
            System.out.println("Product: " + productsTaken.get(i).getName()
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
