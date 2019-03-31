package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		// Instanciando a Exception "DomainException" e passando a string como argumento
		// A operação abaixo lançará uma exceção, caso não passe na validação
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after chek-in date");
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
	
	public long duration() {
		// Obtendo a diferença em milesegundos das datas informadas (checkIn e checkOut)
		long diff = checkOut.getTime() - checkIn.getTime();
		// Convertendo em dias os milesegundos armazenados na variável diff
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	// Utiliznando a Classe RuntimeException não há necessidade de propagar a tratativa das exceçõe no metodo
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			// Instanciando a Exception "DomainException" e passando a string como argumento
			// A operação abaixo lançará uma exceção
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			// Instanciando a Exception "DomainException" e passando a string como argumento
			// A operação abaixo lançará uma exceção
			throw new DomainException("Check-out date must be after chek-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "ROOM "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
				
	}

}
