package Application;

import model.entities.Resevation;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Room Number: ");
            int roomNumber = scanner.nextInt();

            System.out.println();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(scanner.next());

            System.out.println();
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(scanner.next());

            Resevation reservation = new Resevation(roomNumber, checkin, checkout);
            System.out.println("Reservation:" + reservation);


            System.out.println();
            System.out.println("Entre com os dados para atualizar a reserva: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(scanner.next());

            System.out.println();
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(scanner.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }catch (ParseException e){
            System.out.println("Data invalida");
        }catch (DomainExceptions e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }

    }
}