package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {

    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * @return Integer return the roomNumber
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return LocalDate return the checkIn
     */
    public LocalDate getCheckIn() {
        return checkIn;
    }

    /**
     * @return LocalDate return the checkOut
     */
    public LocalDate getCheckOut() {
        return checkOut;
    }

    public int duration() {
        Period duration = Period.between(checkIn, checkOut);
        return duration.getDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: ");
        sb.append("Room ");
        sb.append(roomNumber);
        sb.append(", ");
        sb.append("check-in: ");
        sb.append(fmt.format(checkIn));
        sb.append(", ");
        sb.append("check-out: ");
        sb.append(fmt.format(checkOut));
        sb.append(", ");
        sb.append(duration());
        sb.append(" nights.");
        return sb.toString();
    }

}