class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    MovieTicket(String movieName, String seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = 0.0;
    }

    void bookTicket(double price) {
        this.price = price;
    }

    void displayTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Inception", "A12");
        ticket.bookTicket(250.0);
        ticket.displayTicket();
    }
}