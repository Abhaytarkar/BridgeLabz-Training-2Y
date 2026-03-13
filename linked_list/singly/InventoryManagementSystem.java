import java.util.Scanner;

class Item {

    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }
}

class Inventory {

    Item head = null;

    // Add at beginning
    void addBeginning(int id, String name, int q, double price) {

        Item newItem = new Item(id, name, q, price);

        newItem.next = head;
        head = newItem;

        System.out.println("Item added at beginning");
    }

    // Add at end
    void addEnd(int id, String name, int q, double price) {

        Item newItem = new Item(id, name, q, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newItem;

        System.out.println("Item added at end");
    }

    // Add at position
    void addPosition(int pos, int id, String name, int q, double price) {

        if (pos == 1) {
            addBeginning(id, name, q, price);
            return;
        }

        Item newItem = new Item(id, name, q, price);

        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;

        System.out.println("Item inserted");
    }

    // Remove item by ID
    void removeItem(int id) {

        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        Item temp = head;

        while (temp.next != null && temp.next.id != id)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("Item not found");
        else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    // Update quantity
    void updateQuantity(int id, int newQty) {

        Item temp = head;

        while (temp != null) {

            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search item
    void search(String key) {

        Item temp = head;

        while (temp != null) {

            if (String.valueOf(temp.id).equals(key) ||
                temp.name.equalsIgnoreCase(key)) {

                System.out.println("Item Found");
                System.out.println("ID: " + temp.id);
                System.out.println("Name: " + temp.name);
                System.out.println("Quantity: " + temp.quantity);
                System.out.println("Price: " + temp.price);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Display items
    void display() {

        Item temp = head;

        while (temp != null) {

            System.out.println("--------------------");
            System.out.println("ID: " + temp.id);
            System.out.println("Name: " + temp.name);
            System.out.println("Quantity: " + temp.quantity);
            System.out.println("Price: " + temp.price);

            temp = temp.next;
        }
    }

    // Total inventory value
    void totalValue() {

        Item temp = head;
        double total = 0;

        while (temp != null) {

            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    // Sort by price (simple bubble sort)
    void sortByPrice() {

        if (head == null)
            return;

        for (Item i = head; i.next != null; i = i.next) {

            for (Item j = head; j.next != null; j = j.next) {

                if (j.price > j.next.price) {

                    int id = j.id;
                    String name = j.name;
                    int q = j.quantity;
                    double p = j.price;

                    j.id = j.next.id;
                    j.name = j.next.name;
                    j.quantity = j.next.quantity;
                    j.price = j.next.price;

                    j.next.id = id;
                    j.next.name = name;
                    j.next.quantity = q;
                    j.next.price = p;
                }
            }
        }

        System.out.println("Inventory sorted by price");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        int choice;

        do {

            System.out.println("\n1 Add Beginning");
            System.out.println("2 Add End");
            System.out.println("3 Add Position");
            System.out.println("4 Remove Item");
            System.out.println("5 Update Quantity");
            System.out.println("6 Search Item");
            System.out.println("7 Display Items");
            System.out.println("8 Total Value");
            System.out.println("9 Sort by Price");
            System.out.println("10 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    inv.addBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    inv.addEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    int pos = sc.nextInt();
                    inv.addPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    inv.removeItem(sc.nextInt());
                    break;

                case 5:
                    inv.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    inv.search(sc.next());
                    break;

                case 7:
                    inv.display();
                    break;

                case 8:
                    inv.totalValue();
                    break;

                case 9:
                    inv.sortByPrice();
                    break;
            }

        } while (choice != 10);

        sc.close();
    }
}