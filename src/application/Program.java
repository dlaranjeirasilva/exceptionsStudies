package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			//Parse expection to deal with invalid formats input in dates
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			//Personalized exception to deal with domain errors
			//(called domain error because it deals directly to entities instantied within main program)
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			//Runtime exception do deal with any runtime errors that were not considered within the exceptions already thought
			//(runtime considered because any runtime subclass will be upcasted to a RuntimeException
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
