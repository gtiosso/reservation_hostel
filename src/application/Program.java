// Solução para tratamento de exeções
// Delegando a tratativa de validação da reserva para a classe Reservation e retornando uma string com a mensagem de erro
// Ruim

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		sc.nextLine();
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.nextLine());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after chek-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
		
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.nextLine());
		
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println(reservation);
			}
			
		}
			
		sc.close();
		
	}

}
