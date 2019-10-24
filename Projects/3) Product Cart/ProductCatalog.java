public class ProductCatalog {
    String nameOfCompany;
    Product[] products;
    int numberOfProducts;

    ProductCatalog(final String name) {
        products = new Product[20];
        numberOfProducts = 0;
        nameOfCompany = name;
    }

    public String getName() {
        return nameOfCompany;
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
        System.out.println(nameOfCompany);
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

    public Product get(int index) {
        if (index >= 0 && index < numberOfProducts) {
            return products[index];
        }
        return null;
    }
}
