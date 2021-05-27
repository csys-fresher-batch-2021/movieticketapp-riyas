package in.riyasahamed.convertor;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.model.Seat;

public class SeatConvertor {

	private SeatConvertor() {
		// Default Constructor
	}

	public static SeatDTO toSeatDTO(Seat seat) {

		SeatDTO dto = new SeatDTO();
		dto.setSeatType(seat.getSeatType());
		dto.setPrice(seat.getPrice());
		return dto;
	}

	public static List<SeatDTO> toSeatDTO(List<Seat> seats) {
		List<SeatDTO> dtoList = new ArrayList<>();
		for (Seat seat : seats) {
			SeatDTO dto = SeatConvertor.toSeatDTO(seat);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public static Seat toSeat(SeatDTO seatDTO) {

		Seat seat = new Seat();
		seat.setSeatType(seatDTO.getSeatType());
		seat.setPrice(seatDTO.getPrice());
		return seat;
	}
	
	public static List<Seat> toSeat(List<SeatDTO> seatsDTO) {
		List<Seat> seatsList = new ArrayList<>();
		for (SeatDTO seat : seatsDTO) {
			Seat seats=SeatConvertor.toSeat(seat);
			seatsList.add(seats);
		}
		return seatsList;
	}
	
}
