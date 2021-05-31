package in.riyasahamed.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketDTO {

	private Integer ticketId;

	private MovieDTO movie;

	private SeatDTO seat;

	private UserDTO user;

	private LocalTime showTime;
	
	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public SeatDTO getSeat() {
		return seat;
	}

	public void setSeat(SeatDTO seat) {
		this.seat = seat;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	private LocalDateTime bookingDate;

	private Integer noOfTickets;

	private float totalPrice; 

	
	private LocalDate showDate;

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


	public TicketDTO() {
		// Default Constructor
	}
	
	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", movie=" + movie + ", seat=" + seat + ", user=" + user
				+ ", showTime=" + showTime + ", bookingDate=" + bookingDate + ", noOfTickets=" + noOfTickets
				+ ", totalPrice=" + totalPrice + ", showDate=" + showDate + ", status=" + status + "]";
	}


}
