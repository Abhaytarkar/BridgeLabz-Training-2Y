import java.util.*;

class User {

    int id;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        friends = new ArrayList<>();
        next = null;
    }
}

class SocialMedia {

    User head = null;

    // Add new user
    void addUser(int id, String name, int age) {

        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newUser;
        }

        System.out.println("User added");
    }

    // Find user by ID
    User findUser(int id) {

        User temp = head;

        while (temp != null) {
            if (temp.id == id)
                return temp;

            temp = temp.next;
        }

        return null;
    }

    // Add friend connection
    void addFriend(int id1, int id2) {

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friends.add(id2);
        u2.friends.add(id1);

        System.out.println("Friend connection added");
    }

    // Remove friend connection
    void removeFriend(int id1, int id2) {

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend removed");
    }

    // Display friends of user
    void displayFriends(int id) {

        User user = findUser(id);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.name + ": " + user.friends);
    }

    // Search user
    void searchUser(String key) {

        User temp = head;

        while (temp != null) {

            if (temp.name.equalsIgnoreCase(key) || String.valueOf(temp.id).equals(key)) {

                System.out.println("User Found");
                System.out.println("ID: " + temp.id);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                return;
            }

            temp = temp.next;
        }

        System.out.println("User not found");
    }

    // Count friends
    void countFriends() {

        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends");
            temp = temp.next;
        }
    }

    // Mutual friends
    void mutualFriends(int id1, int id2) {

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends IDs: ");

        for (int f : u1.friends) {
            if (u2.friends.contains(f)) {
                System.out.print(f + " ");
            }
        }

        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        int choice;

        do {

            System.out.println("\n1 Add User");
            System.out.println("2 Add Friend");
            System.out.println("3 Remove Friend");
            System.out.println("4 Display Friends");
            System.out.println("5 Search User");
            System.out.println("6 Count Friends");
            System.out.println("7 Mutual Friends");
            System.out.println("8 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter User1 ID: ");
                    int u1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    int u2 = sc.nextInt();
                    sm.addFriend(u1, u2);
                    break;

                case 3:
                    System.out.print("Enter User1 ID: ");
                    int r1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    int r2 = sc.nextInt();
                    sm.removeFriend(r1, r2);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int fid = sc.nextInt();
                    sm.displayFriends(fid);
                    break;

                case 5:
                    System.out.print("Enter Name or ID: ");
                    String key = sc.next();
                    sm.searchUser(key);
                    break;

                case 6:
                    sm.countFriends();
                    break;

                case 7:
                    System.out.print("Enter User1 ID: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    int m2 = sc.nextInt();
                    sm.mutualFriends(m1, m2);
                    break;
            }

        } while (choice != 8);

        sc.close();
    }
}