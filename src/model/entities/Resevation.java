package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Resevation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Resevation(int roomNumber, Date checkin, Date checkout) {
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

    public String updateDates(Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            return "Erro na reserva, a reserva esta a frente da data de hoje";
        }if (!checkout.after(checkin)) {
            return "Erro na reserva: Checkout depois do checkin";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString(){
        return "Room: " + roomNumber + ", checkin: " + sdf.format(checkin) + ", checkout: "
                + sdf.format(checkout) + ", " + duration() + " nights";
    }
}
