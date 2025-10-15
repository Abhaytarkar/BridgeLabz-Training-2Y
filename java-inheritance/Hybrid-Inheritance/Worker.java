interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Preparing dishes. Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    private int tableCount;

    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println("Serving customers at " + tableCount + " tables.");
    }
}

public class RestaurantTest {
    public static void main(String[] args) {
        Worker w1 = new Chef("Raj", 101, "Italian Cuisine");
        Worker w2 = new Waiter("Priya", 102, 5);

        System.out.println("-----");
        ((Person) w1).displayInfo();
        w1.performDuties();

        System.out.println("-----");
        ((Person) w2).displayInfo();
        w2.performDuties();
    }
}