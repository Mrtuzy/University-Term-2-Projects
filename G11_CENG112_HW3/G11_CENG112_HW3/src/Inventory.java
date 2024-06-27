public class Inventory {
    private Tree<Product> productTree;

    public Inventory() {
        productTree = new Tree<>();
    }

    public void addProduct(String category, String name, double price) {
        Product product = new Product(name, category, price);
        productTree.add(productTree.getRoot(), product);
        System.out.println();
        System.out.println("Adding: " + product);
    }

    public void searchProduct(String name) {
        Product dummyProduct = new Product(name, null, 0);
        boolean result = productTree.searchWithTraversal(productTree.getRoot(),dummyProduct);
        System.out.println();

        if (result) {
            System.out.println("Found: " + name);
        } else {
            System.out.println("Not Found: " + name);
        }
    }

    public void listProducts() {
        System.out.println();
        System.out.println("Listing:");
        productTree.list();
    }

}
