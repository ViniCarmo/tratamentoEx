package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Resevation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Resevation(int roomNumber, Date checkin, Date checkout){
        if (!checkout.after(checkin)) {
            throw new DomainExceptions("Erro na reserva: Checkout antes do checkin") ;
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainExceptions("Erro na reserva, a reserva esta em uma data passada");
        }if (!checkout.after(checkin)) {
            throw new DomainExceptions("Erro na reserva: Checkout antes do checkin") ;
        }

        this.checkin = checkin;
        this.checkout = checkout;

    }

    @Override
    public String toString(){
        return "Room: " + roomNumber + ", checkin: " + sdf.format(checkin) + ", checkout: "
                + sdf.format(checkout) + ", " + duration() + " nights";
    }
}
