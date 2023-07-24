package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

	public static DateTimeFormatter formated = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public Long duration() {
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}

	public String updtadeDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate nowDate = LocalDate.now();

		if (checkIn.isBefore(nowDate) || checkOut.isBefore(nowDate)) {
			return "Reservation dates for update must be future dates";
		}
		if (checkOut.isBefore(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + formated.format(checkIn) + ", check-out: "
				+ formated.format(checkOut) + ", " + duration() + " nights";
	}
}
