public class Main {
    public static void main(String[] args) {
        Store s = new Store("shopp", 3);
        Product p1 = new Product("Notebook", 12.5, 3);
        s.addProduct(p1);
        Product p2 = new Product("Pen", 4.0, 2);
        s.addProduct(p2);
        Product p3 = new Product("Bottle", 30.0, 0);
        s.addProduct(p3);
        s.printSalesReport();
        System.out.println();

        Product p4 = new Product("Book", 2.0, 2);
        System.out.println(s.addProduct(p4));
        System.out.println();

        s.sellProduct(1000, 2);
        s.sellProduct(1001, 3);
        s.printSalesReport();
        s.sellProduct(1001, 2);
        s.printSalesReport();
        System.out.println();

        System.out.println(p1.getPrice());
        p1.setPrice(-5.0);
        System.out.println(p1.getPrice());
        System.out.println();

        s.printAvailableProducts();
        s.printSalesReport();
        System.out.println(s.getTotalUnitsSold());
        System.out.println();

        System.out.println(p1.getId());
        System.out.println(p2.getId());
        System.out.println(p3.getId());
        System.out.println(p4.getId());
        System.out.println(Product.getNextId());
    }
}
