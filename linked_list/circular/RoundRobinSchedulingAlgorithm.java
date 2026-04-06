import java.util.Scanner;

class Process {

    int pid;
    int burstTime;
    int priority;
    Process next;

    Process(int pid, int bt, int pr) {
        this.pid = pid;
        burstTime = bt;
        priority = pr;
        next = null;
    }
}

class RoundRobin {

    Process head = null;

    // Add process
    void addProcess(int pid, int bt, int pr) {

        Process newP = new Process(pid, bt, pr);

        if (head == null) {
            head = newP;
            newP.next = head;
        } else {

            Process temp = head;

            while (temp.next != head)
                temp = temp.next;

            temp.next = newP;
            newP.next = head;
        }

        System.out.println("Process added");
    }

    // Remove process
    void removeProcess(int pid) {

        if (head == null)
            return;

        Process temp = head;
        Process prev = null;

        if (head.pid == pid) {

            if (head.next == head) {
                head = null;
                return;
            }

            Process last = head;

            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;

            return;
        }

        do {

            prev = temp;
            temp = temp.next;

            if (temp.pid == pid) {
                prev.next = temp.next;
                return;
            }

        } while (temp != head);
    }

    // Display processes
    void display() {

        if (head == null) {
            System.out.println("No processes");
            return;
        }

        Process temp = head;

        do {

            System.out.println("PID: " + temp.pid +
                               " Burst: " + temp.burstTime +
                               " Priority: " + temp.priority);

            temp = temp.next;

        } while (temp != head);
    }

    // Round Robin scheduling
    void schedule(int quantum) {

        if (head == null)
            return;

        Process temp = head;

        int totalWaiting = 0;
        int totalTurnaround = 0;
        int count = 0;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        temp = head;

        while (head != null) {

            if (temp.burstTime > quantum) {

                System.out.println("Process " + temp.pid +
                        " executed for " + quantum);

                temp.burstTime -= quantum;

            } else {

                System.out.println("Process " + temp.pid +
                        " finished execution");

                totalTurnaround += temp.burstTime;
                removeProcess(temp.pid);

                if (head == null)
                    break;

                temp = head;
                continue;
            }

            temp = temp.next;

            System.out.println("Queue after round:");
            display();
        }

        System.out.println("Average Turnaround Time: " +
                (double) totalTurnaround / count);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobin rr = new RoundRobin();

        int choice;

        do {

            System.out.println("\n1 Add Process");
            System.out.println("2 Display Processes");
            System.out.println("3 Start Scheduling");
            System.out.println("4 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Process ID: ");
                    int id = sc.nextInt();

                    System.out.print("Burst Time: ");
                    int bt = sc.nextInt();

                    System.out.print("Priority: ");
                    int pr = sc.nextInt();

                    rr.addProcess(id, bt, pr);
                    break;

                case 2:
                    rr.display();
                    break;

                case 3:

                    System.out.print("Enter Time Quantum: ");
                    int q = sc.nextInt();

                    rr.schedule(q);
                    break;
            }

        } while (choice != 4);

        sc.close();
    }
}