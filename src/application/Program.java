// Solução para tratamento de exceções
// Tratando todas as exceções e validações atraves de Exceptions (Nativas e Customizadas)
// Boa

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		// Iniciando um bloco Try-Catch
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			sc.nextLine();
			Date checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.nextLine());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.nextLine());
		
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} 
		// Capturando exceções do tipo "ParseException"
		catch (ParseException e) {
			System.out.println("Invalid Date Informed!" + e.getMessage());
		}
		// Capturando exceções do tipo "DomainException" -> Instanciada no objeto Reservation
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		// Tratando todas as outras exceções, através de UPCASTING para a Classe RuntimeException
		// Criando um erro genérico
		catch (RuntimeException e) {
			System.out.println("Unexpected Error: ");
		}
		// Finalmente em caso de sucesso ou insucesso, fechando o Scanner
		finally {
			sc.close();	
		}
	}
}
