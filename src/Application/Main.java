package Application;

import model.entities.Resevation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room Number: ");
        int roomNumber = scanner.nextInt();

        System.out.println();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(scanner.next());

        System.out.println();
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(scanner.next());

        if (!checkout.after(checkin)) {
            System.out.println("Erro na reserva: Checkout depois do checkin");
        } else {
            Resevation reservation = new Resevation(roomNumber, checkin, checkout);
            System.out.println("Reservation:" + reservation);


            System.out.println();
            System.out.println("Entre com os dados para atualizar a reserva: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(scanner.next());

            System.out.println();
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(scanner.next());


            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("Erro na reserva, a reserva esta a frente da data de hoje");
            } else if (!checkout.after(checkin)) {
                System.out.println("Erro na reserva: Checkout depois do checkin");
            } else {


                reservation.updateDates(checkin, checkout);

                System.out.println("Reservation: " + reservation);
            }
        }

    }
}