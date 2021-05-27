package in.riyasahamed.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

	private Integer ticketId;

	private LocalDateTime bookingDate;

	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Integer noOfTickets;

	private float totalPrice;

	private LocalDate showDate;
	
	private Movie movie;
	
	private Seat seat;
	
	private User user;

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Ticket() {
		// Default Constructor
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingDate=" + bookingDate + ", noOfTickets=" + noOfTickets
				+ ", totalPrice=" + totalPrice + ", showDate=" + showDate + ", movie=" + movie + ", seat=" + seat
				+ ", user=" + user + ", status=" + status + "]";
	}


}
