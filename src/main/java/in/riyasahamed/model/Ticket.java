package in.riyasahamed.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

	private Integer ticketId;

	private String movieName;

	private String seatType;

	private LocalDateTime bookingDate;

	private Integer noOfTickets;

	private float totalPrice;

	private String userName;

	private String name;

	private String actor;

	private LocalDate showDate;

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Integer UserId;

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	private Integer movieId;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", movieName=" + movieName + ", seatType=" + seatType + ", bookingDate="
				+ bookingDate + ", noOfTickets=" + noOfTickets + ", totalPrice=" + totalPrice + ", userName=" + userName
				+ ", name=" + name + ", actor=" + actor + ", showDate=" + showDate + "]";
	}

	public Ticket() {
		// Default Constructor
	}

}
