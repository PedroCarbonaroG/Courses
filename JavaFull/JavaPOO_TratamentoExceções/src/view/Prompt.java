package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Prompt {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private Reservation reservation;

    public void startPrompt() {
        
        try {
            System.out.println("======================================================");
            System.out.print("Room number: "); short roomNumber = sc.nextShort();
            sc.nextLine(); // Cleaning the SCANNER buffer
            System.out.print("Check-in date (DD/MM/YYYY): "); String dateIn = sc.nextLine();
            System.out.print("Check-out date (DD/MM/YYYY): "); String dateOut = sc.nextLine();

            reservation = new Reservation(roomNumber, sdf.parse(dateIn), sdf.parse(dateOut));
            System.out.println(reservation);

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): "); dateIn = sc.nextLine();
            System.out.print("Check-out date (DD/MM/YYYY): "); dateOut = sc.nextLine();
            reservation.updateDates(sdf.parse(dateIn), sdf.parse(dateOut));

            System.out.println(reservation);

        }
        catch (ParseException e) { System.out.println("Invalid date format"); }
        catch (RuntimeException e) { System.out.println("Unexpected error!"); }
        catch (DomainException e) { System.out.println("Error in reservation: " + e.getMessage()); }

        sc.close();
    }
}
