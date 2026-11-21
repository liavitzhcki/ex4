public class Product {
    private int id; //מספר מזהה ייחודי למוצר
    private String name; //שם המוצר
    private double price; //מחיר יחידה
    private int stock; //מספר היחידות הזמינות במלאי
    private static int nextId = 1000; //המזהה שיקבל המוצר הבא

    public Product(String name, double price, int stock) {
        id = nextId++;
        if (!this.setName(name))
            this.name = "Unknown";
        if (!this.setPrice(price))
            this.price = 1.0;
        if (!this.setStock(stock))
            this.stock = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public int getStock() {
        return stock;
    }

    public boolean setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            return true;
        }
        return false;
    }

    public static int getNextId() {
        return nextId;
    }

    public boolean sell(int quantity) {
        if (quantity > 0)
            return setStock(stock - quantity);
        return false;
    }

    public String getInfo() {
        return "id: " + id + ", name: " + name + ", price: " + price + ", stock: " + stock;
    }
}