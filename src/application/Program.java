package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);

		System.out.print("Room number: ");
		int number = read.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		if (checkout.isBefore(checkin)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			LocalDate nowDate = LocalDate.now();

			if (checkin.isBefore(nowDate) || checkout.isBefore(nowDate)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (checkout.isBefore(checkin)) {
				System.out.println("Error in Reservation: Check-out date must be after check-in date");
			} else {
				reservation.updtadeDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
		}

		read.close();
	}

}
