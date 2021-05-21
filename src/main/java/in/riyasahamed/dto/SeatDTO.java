package in.riyasahamed.dto;

public class SeatDTO {
		
		private String seatType;
		
		private Integer price;

		public String getSeatType() {
			return seatType;
		}

		public Integer getPrice() {
			return price;
		}
		
		public SeatDTO(String seatType, Integer price) {
			this.seatType=seatType;
			this.price=price;
		}

		public SeatDTO() {
			// Default Constructor
		}

		public void setSeatType(String seatType) {
			this.seatType = seatType;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Seat [seatType=" + seatType + ", price=" + price + "]";
		}

	}


