package in.riyasahamed.service;

import java.time.LocalTime;
import java.util.List;

public class ShowTimesTest {

	public static void main(String[] args) {
		List<LocalTime> showTimes = TicketService.getShowTimes();
		System.out.println(showTimes);
		
	}
}
