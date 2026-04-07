import java.util.Scanner;

class Task {

    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        next = null;
    }
}

class TaskScheduler {

    Task head = null;
    Task current = null;

    // Add task at beginning
    void addBeginning(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {

            Task temp = head;

            while (temp.next != head)
                temp = temp.next;

            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }

        System.out.println("Task added at beginning");
    }

    // Add task at end
    void addEnd(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }

        Task temp = head;

        while (temp.next != head)
            temp = temp.next;

        temp.next = newTask;
        newTask.next = head;

        System.out.println("Task added at end");
    }

    // Add task at position
    void addPosition(int pos, int id, String name, int priority, String dueDate) {

        if (pos == 1) {
            addBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);

        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newTask.next = temp.next;
        temp.next = newTask;

        System.out.println("Task inserted");
    }

    // Remove task by ID
    void removeTask(int id) {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        Task prev = null;

        if (head.id == id) {

            if (head.next == head) {
                head = null;
                return;
            }

            Task last = head;

            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;

            System.out.println("Task removed");
            return;
        }

        do {

            prev = temp;
            temp = temp.next;

            if (temp.id == id) {
                prev.next = temp.next;
                System.out.println("Task removed");
                return;
            }

        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task and move next
    void nextTask() {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        if (current == null)
            current = head;
        else
            current = current.next;

        System.out.println("Current Task:");
        System.out.println("ID: " + current.id);
        System.out.println("Name: " + current.name);
        System.out.println("Priority: " + current.priority);
        System.out.println("Due Date: " + current.dueDate);
    }

    // Display all tasks
    void display() {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;

        do {

            System.out.println("------------------");
            System.out.println("ID: " + temp.id);
            System.out.println("Name: " + temp.name);
            System.out.println("Priority: " + temp.priority);
            System.out.println("Due Date: " + temp.dueDate);

            temp = temp.next;

        } while (temp != head);
    }

    // Search by priority
    void searchPriority(int priority) {

        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {

            if (temp.priority == priority) {

                System.out.println("Task Found");
                System.out.println("ID: " + temp.id);
                System.out.println("Name: " + temp.name);
                System.out.println("Due Date: " + temp.dueDate);

                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found)
            System.out.println("No task with given priority");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskScheduler ts = new TaskScheduler();

        int choice;

        do {

            System.out.println("\n1 Add Beginning");
            System.out.println("2 Add End");
            System.out.println("3 Add Position");
            System.out.println("4 Remove Task");
            System.out.println("5 Next Task");
            System.out.println("6 Display Tasks");
            System.out.println("7 Search by Priority");
            System.out.println("8 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ts.addBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 2:
                    ts.addEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 3:
                    int pos = sc.nextInt();
                    ts.addPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 4:
                    ts.removeTask(sc.nextInt());
                    break;

                case 5:
                    ts.nextTask();
                    break;

                case 6:
                    ts.display();
                    break;

                case 7:
                    ts.searchPriority(sc.nextInt());
                    break;
            }

        } while (choice != 8);

        sc.close();
    }
}