package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

              /*
            Checking validation dates  - 3 solution (very good).
            using try/catch and a custom DomainException was created
            */

        try {

            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // method - updateDates
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Error in reservation! " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format!");
        }
        catch (DomainException e){
            System.out.println("Error in reservation! " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error - Try again!");
        }
        sc.close();
    }
}
