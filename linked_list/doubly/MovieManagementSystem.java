import java.util.Scanner;

class Movie {

    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        next = null;
        prev = null;
    }
}

class MovieList {

    Movie head = null;
    Movie tail = null;

    // Add movie at beginning
    void addBeginning(String title, String director, int year, double rating) {

        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }

        System.out.println("Movie added at beginning");
    }

    // Add movie at end
    void addEnd(String title, String director, int year, double rating) {

        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }

        System.out.println("Movie added at end");
    }

    // Add movie at position
    void addPosition(int pos, String title, String director, int year, double rating) {

        if (pos == 1) {
            addBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newMovie.next = temp.next;

        if (temp.next != null)
            temp.next.prev = newMovie;
        else
            tail = newMovie;

        temp.next = newMovie;
        newMovie.prev = temp;

        System.out.println("Movie inserted");
    }

    // Remove movie by title
    void removeMovie(String title) {

        Movie temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                System.out.println("Movie removed");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Search movie by director or rating
    void search(String director, double rating) {

        Movie temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.director.equalsIgnoreCase(director) ||
                temp.rating == rating) {

                System.out.println("Movie Found");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);

                found = true;
            }

            temp = temp.next;
        }

        if (!found)
            System.out.println("No matching movie found");
    }

    // Update rating
    void updateRating(String title, double newRating) {

        Movie temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    void displayForward() {

        Movie temp = head;

        while (temp != null) {

            System.out.println("----------------");
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);

            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {

        Movie temp = tail;

        while (temp != null) {

            System.out.println("----------------");
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);

            temp = temp.prev;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieList ml = new MovieList();

        int choice;

        do {

            System.out.println("\n1 Add Beginning");
            System.out.println("2 Add End");
            System.out.println("3 Add Position");
            System.out.println("4 Remove Movie");
            System.out.println("5 Search Movie");
            System.out.println("6 Update Rating");
            System.out.println("7 Display Forward");
            System.out.println("8 Display Reverse");
            System.out.println("9 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ml.addBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    ml.addEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    int pos = sc.nextInt();
                    ml.addPosition(pos, sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    ml.removeMovie(sc.next());
                    break;

                case 5:
                    ml.search(sc.next(), sc.nextDouble());
                    break;

                case 6:
                    ml.updateRating(sc.next(), sc.nextDouble());
                    break;

                case 7:
                    ml.displayForward();
                    break;

                case 8:
                    ml.displayReverse();
                    break;
            }

        } while (choice != 9);

        sc.close();
    }
}