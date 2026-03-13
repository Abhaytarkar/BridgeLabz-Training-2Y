import java.util.Scanner;

class State {

    String text;
    State prev;
    State next;

    State(String text) {
        this.text = text;
        prev = null;
        next = null;
    }
}

class TextEditor {

    State head = null;
    State current = null;
    int size = 0;
    int limit = 10;   // history limit

    // Add new state
    void addState(String text) {

        State newState = new State(text);

        if (head == null) {
            head = newState;
            current = newState;
            size++;
            return;
        }

        // remove redo states
        current.next = null;

        newState.prev = current;
        current.next = newState;
        current = newState;

        if (size < limit) {
            size++;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Undo
    void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }

        current = current.prev;
        System.out.println("Undo Successful");
    }

    // Redo
    void redo() {

        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }

        current = current.next;
        System.out.println("Redo Successful");
    }

    // Display current text
    void displayCurrent() {

        if (current == null) {
            System.out.println("No text available");
        } else {
            System.out.println("Current Text State: " + current.text);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int choice;

        do {

            System.out.println("\n1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrent();
                    break;
            }

        } while (choice != 5);

        sc.close();
    }
}