public class ProductCatalog {
    Product[] products;
    int numberOfProducts;

    ProductCatalog() {
        products = new Product[20];
        numberOfProducts = 0;
    }

    public void addProductToCatalog(final Product product) {
        if (numberOfProducts == 0) {
            products[numberOfProducts++] = product;
        } else {
            boolean flag = true;
            for (int i = 0; i < numberOfProducts; i++) {
                if (products[i].getName().equals(product.getName())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                products[numberOfProducts++] = product;
            }
        }
    }

    public void showCatalog() {
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println(products[i]);
        }
    }

    public Product searchProductFromCatalog(final String name) {
        for (int i = 0; i < numberOfProducts; i++) {
            if (products[i].getName().equals(name)) {
                return products[i];
            }
        }
        return null;
    }
}
