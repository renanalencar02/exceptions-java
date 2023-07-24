package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = read.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			reservation.updtadeDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		}
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		read.close();
	}

}
