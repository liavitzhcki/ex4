public class Store {
    private String storeName; //שם החנות
    private Product[] products; //המוצרים שנוספו לחנות
    private int[] soldCount; //מספר היחידות שנמכרו מכל מוצר
    private int productCount; //מספר המוצרים שנוספו בפועל

    public Store(String storeName, int capacity) {
        this.storeName = storeName;
        products = new Product[capacity];
        soldCount = new int[capacity];
    }

    boolean addProduct(Product product) {
        if (productCount == products.length || product == null)
            return false;
        if (this.findProductIndex(product.getId()) == -1) {
            products[productCount++] = product;
            return true;
        }
        return false;
    }

    public int findProductIndex(int id) {
        int i = 0;
        while (i < productCount) {
            if (id == products[i].getId())
                break;
            i++;
        }
        return i == productCount ? -1 : i;
    }

    public boolean sellProduct(int id, int quantity) {
        int i = this.findProductIndex(id);
        if (i == -1)
            return false;
        if (products[i].sell(quantity)) {
            soldCount[i] += quantity;
            return true;
        }
        return false;
    }

    public void printAvailableProducts() {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getStock() == 0)
                continue;
            System.out.println(products[i].getInfo());
        }
    }

    public void printSalesReport() {
        System.out.println("Store name: " + storeName);
        for (int i = 0; i < productCount; i++) {
            System.out.println("product name: " + products[i].getName() + ", sold: " + soldCount[i]);
        }
    }

    public int getTotalUnitsSold() {
        int sum = 0;
        for (int i : soldCount) {
            sum += i;
        }
        return sum;
    }
}
