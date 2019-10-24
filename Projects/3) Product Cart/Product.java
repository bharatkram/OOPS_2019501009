public class Product {
    /**
     * field to store the product's ID.
     */
    int productID;

    /**
     * field to store the name of the product.
     */
    String name;

    /**
     * field to store the quantity of the product available.
     */
    int qty;

    /**
     * field to store the price of the product.
     */
    int price;

    /**
     * default constructor.
     */
    public Product() {
    }

    public Product(int productID, String name, int qty, int price) {
        this.productID = productID;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    /**
     * function to get the ID of the product.
     *
     * @return the product ID.
     */
    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "productID='" + productID + "'" 
            + ", name='" + name + "'"
            + ", qty='" + qty + "'"
            + ", price='" + price + "'";
    }

}
