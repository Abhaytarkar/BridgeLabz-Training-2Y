import java.util.Scanner;

class Book {

    int id;
    String title;
    String author;
    String genre;
    boolean available;

    Book next;
    Book prev;

    Book(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        next = null;
        prev = null;
    }
}

class Library {

    Book head = null;

    // Add at beginning
    void addBeginning(int id, String title, String author, String genre, boolean available) {

        Book newBook = new Book(id, title, author, genre, available);

        if (head != null)
            head.prev = newBook;

        newBook.next = head;
        head = newBook;

        System.out.println("Book added at beginning");
    }

    // Add at end
    void addEnd(int id, String title, String author, String genre, boolean available) {

        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = newBook;
            return;
        }

        Book temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newBook;
        newBook.prev = temp;

        System.out.println("Book added at end");
    }

    // Add at position
    void addPosition(int pos, int id, String title, String author, String genre, boolean available) {

        if (pos == 1) {
            addBeginning(id, title, author, genre, available);
            return;
        }

        Book newBook = new Book(id, title, author, genre, available);

        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newBook.next = temp.next;

        if (temp.next != null)
            temp.next.prev = newBook;

        temp.next = newBook;
        newBook.prev = temp;

        System.out.println("Book inserted");
    }

    // Remove book
    void removeBook(int id) {

        Book temp = head;

        while (temp != null) {

            if (temp.id == id) {

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Book removed");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Search book
    void search(String key) {

        Book temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(key) ||
                temp.author.equalsIgnoreCase(key)) {

                System.out.println("Book Found");
                System.out.println("ID: " + temp.id);
                System.out.println("Title: " + temp.title);
                System.out.println("Author: " + temp.author);
                System.out.println("Genre: " + temp.genre);
                System.out.println("Available: " + temp.available);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Update availability
    void updateStatus(int id, boolean status) {

        Book temp = head;

        while (temp != null) {

            if (temp.id == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Display forward
    void displayForward() {

        Book temp = head;

        while (temp != null) {

            System.out.println("----------------");
            System.out.println("ID: " + temp.id);
            System.out.println("Title: " + temp.title);
            System.out.println("Author: " + temp.author);
            System.out.println("Genre: " + temp.genre);
            System.out.println("Available: " + temp.available);

            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {

        if (head == null)
            return;

        Book temp = head;

        while (temp.next != null)
            temp = temp.next;

        while (temp != null) {

            System.out.println("----------------");
            System.out.println("ID: " + temp.id);
            System.out.println("Title: " + temp.title);
            System.out.println("Author: " + temp.author);
            System.out.println("Genre: " + temp.genre);
            System.out.println("Available: " + temp.available);

            temp = temp.prev;
        }
    }

    // Count books
    void countBooks() {

        int count = 0;

        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books: " + count);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        int choice;

        do {

            System.out.println("\n1 Add Beginning");
            System.out.println("2 Add End");
            System.out.println("3 Add Position");
            System.out.println("4 Remove Book");
            System.out.println("5 Search Book");
            System.out.println("6 Update Availability");
            System.out.println("7 Display Forward");
            System.out.println("8 Display Reverse");
            System.out.println("9 Count Books");
            System.out.println("10 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    lib.addBeginning(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
                    break;

                case 2:
                    lib.addEnd(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
                    break;

                case 3:
                    int pos = sc.nextInt();
                    lib.addPosition(pos, sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
                    break;

                case 4:
                    lib.removeBook(sc.nextInt());
                    break;

                case 5:
                    lib.search(sc.next());
                    break;

                case 6:
                    lib.updateStatus(sc.nextInt(), sc.nextBoolean());
                    break;

                case 7:
                    lib.displayForward();
                    break;

                case 8:
                    lib.displayReverse();
                    break;

                case 9:
                    lib.countBooks();
                    break;
            }

        } while (choice != 10);

        sc.close();
    }
}