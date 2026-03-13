import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {

    Student head;

    // Add at beginning
    void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at beginning");
    }

    // Add at end
    void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        System.out.println("Student added at end");
    }

    // Add at position
    void addAtPosition(int pos, int roll, String name, int age, String grade) {

        if (pos == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Student added at position " + pos);
    }

    // Delete by roll number
    void deleteByRoll(int roll) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    // Search by roll number
    void search(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Student Found:");
                System.out.println("Roll: " + temp.roll);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Update grade
    void updateGrade(int roll, String newGrade) {

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Display records
    void display() {

        if (head == null) {
            System.out.println("No records");
            return;
        }

        Student temp = head;

        while (temp != null) {
            System.out.println("----------------------");
            System.out.println("Roll: " + temp.roll);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        int choice;

        do {

            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Display");
            System.out.println("7.Update Grade");
            System.out.println("8.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Roll: ");
                    int r1 = sc.nextInt();
                    System.out.print("Name: ");
                    String n1 = sc.next();
                    System.out.print("Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Grade: ");
                    String g1 = sc.next();
                    list.addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Roll: ");
                    int r2 = sc.nextInt();
                    System.out.print("Name: ");
                    String n2 = sc.next();
                    System.out.print("Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Grade: ");
                    String g2 = sc.next();
                    list.addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Roll: ");
                    int r3 = sc.nextInt();
                    System.out.print("Name: ");
                    String n3 = sc.next();
                    System.out.print("Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Grade: ");
                    String g3 = sc.next();
                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter roll to delete: ");
                    int d = sc.nextInt();
                    list.deleteByRoll(d);
                    break;

                case 5:
                    System.out.print("Enter roll to search: ");
                    int s = sc.nextInt();
                    list.search(s);
                    break;

                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.print("Enter roll: ");
                    int ur = sc.nextInt();
                    System.out.print("New Grade: ");
                    String ng = sc.next();
                    list.updateGrade(ur, ng);
                    break;
            }

        } while (choice != 8);

        sc.close();
    }
}