package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        /*
        Checking validation dates  - 2 solution (bad).
        One part of the solution has been implemented in the Reservation Class, but another part is still
        being implemented in the main class.
        */
        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation! Check-out date must be after Check-in date.");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // method - updateDates
            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println("Error in reservation! " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }
}
