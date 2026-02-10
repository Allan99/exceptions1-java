import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.err.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), fmt);

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        sc.close();
    }
}
