public class ShopOnline {

    ProductCatalog company1;
    User user;

    ShopOnline() {
        company1 = new ProductCatalog();
        user = new User("Ram");
    }

    public void Shopping() {

        company1.addProductToCatalog(new Product(001, "phone", 5, 50000));
        company1.addProductToCatalog(new Product(001, "charger", 10, 1000));
        company1.addProductToCatalog(new Product(001, "earphones", 10, 2000));
        company1.addProductToCatalog(new Product(001, "cover1", 20, 150));
        company1.addProductToCatalog(new Product(001, "cover2", 20, 500));
        company1.addProductToCatalog(new Product(001, "screen guard", 20, 50));

        company1.showCatalog();
    }

    public static void main(String[] args) {
        ShopOnline s = new ShopOnline();
        s.shopping();
    }
}