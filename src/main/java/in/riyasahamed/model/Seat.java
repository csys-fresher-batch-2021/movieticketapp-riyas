package in.riyasahamed.model;

public class Seat {
	
	private String seatType;
	
	private Integer price;

	public String getSeatType() {
		return seatType;
	}

	public Integer getPrice() {
		return price;
	}
	
	public Seat(String seatType, Integer price) {
		this.seatType=seatType;
		this.price=price;
	}

	@Override
	public String toString() {
		return "Seat [seatType=" + seatType + ", price=" + price + "]";
	}

}
