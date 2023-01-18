package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after Check-in date.");
        }
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

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //return the amount of days between two different dates
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }


    //gets two new dates to update checkIn and CheckOut
    public void updateDates(Date checkIn, Date checkOut) {

        //Checking validation dates  - 3 solution (very good) created a custom exception DomainException
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after Check-in date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", Check-in: "
                + sdf.format(checkIn)
                + ", Check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " night(s).";
    }
}
