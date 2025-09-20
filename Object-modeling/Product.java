class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    int orderId;
    List<Product> products = new ArrayList<>();
    Order(int orderId) {
        this.orderId = orderId;
    }
    void addProduct(Product p) {
        products.add(p);
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();
    Customer(String name) {
        this.name = name;
    }
    void placeOrder(Order o) {
        orders.add(o);
    }
}