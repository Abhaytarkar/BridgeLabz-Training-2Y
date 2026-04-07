import java.util.Scanner;

class Ticket {

    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;

    Ticket next;

    Ticket(int id, String cname, String mname, int seat, String time) {
        ticketId = id;
        customerName = cname;
        movieName = mname;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

class CircularTicketList {

    Ticket head = null;

    // Add ticket at end
    void addTicket(int id, String cname, String mname, int seat, String time) {

        Ticket newNode = new Ticket(id, cname, mname, seat, time);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {

            Ticket temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Ticket Reserved Successfully");
    }

    // Remove ticket by ID
    void removeTicket(int id) {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // If head is to be deleted
        if (head.ticketId == id) {

            if (head.next == head) {
                head = null;
                return;
            }

            Ticket last = head;
            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;
            System.out.println("Ticket Removed");
            return;
        }

        do {

            prev = temp;
            temp = temp.next;

            if (temp.ticketId == id) {
                prev.next = temp.next;
                System.out.println("Ticket Removed");
                return;
            }

        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Display tickets
    void displayTickets() {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;

        do {

            System.out.println("------------------------");
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Customer Name: " + temp.customerName);
            System.out.println("Movie Name: " + temp.movieName);
            System.out.println("Seat Number: " + temp.seatNumber);
            System.out.println("Booking Time: " + temp.bookingTime);

            temp = temp.next;

        } while (temp != head);
    }

    // Search ticket
    void searchTicket(String key) {

        if (head == null) {
            System.out.println("No tickets found");
            return;
        }

        Ticket temp = head;

        do {

            if (temp.customerName.equalsIgnoreCase(key) ||
                temp.movieName.equalsIgnoreCase(key)) {

                System.out.println("Ticket Found:");
                System.out.println("Ticket ID: " + temp.ticketId);
                System.out.println("Customer: " + temp.customerName);
                System.out.println("Movie: " + temp.movieName);
                System.out.println("Seat: " + temp.seatNumber);
                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Count total tickets
    void countTickets() {

        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Booked Tickets: " + count);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularTicketList list = new CircularTicketList();

        int choice;

        do {

            System.out.println("\n1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Total Tickets");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();

                    System.out.print("Customer Name: ");
                    String cname = sc.next();

                    System.out.print("Movie Name: ");
                    String mname = sc.next();

                    System.out.print("Seat Number: ");
                    int seat = sc.nextInt();

                    System.out.print("Booking Time: ");
                    String time = sc.next();

                    list.addTicket(id, cname, mname, seat, time);
                    break;

                case 2:

                    System.out.print("Enter Ticket ID to remove: ");
                    int rid = sc.nextInt();
                    list.removeTicket(rid);
                    break;

                case 3:
                    list.displayTickets();
                    break;

                case 4:

                    System.out.print("Enter Customer or Movie Name: ");
                    String key = sc.next();
                    list.searchTicket(key);
                    break;

                case 5:
                    list.countTickets();
                    break;

            }

        } while (choice != 6);

        sc.close();
    }
}