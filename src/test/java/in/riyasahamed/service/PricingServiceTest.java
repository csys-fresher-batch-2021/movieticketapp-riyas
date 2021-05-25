package in.riyasahamed.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PricingServiceTest {

	@Test
	public void testForSilverSeatType() {
		
		float totalPrice=PricingService.getPrice("silver", 10);
		assertEquals(708,totalPrice,2);
		
	}
	
	@Test
	public void testForGoldSeatType() {
		
		float totalPrice=PricingService.getPrice("gold", 10);
		assertEquals(1416,totalPrice,2);
		
	}
	
	@Test
	public void testForPlatinumSeatType() {
		
		float totalPrice=PricingService.getPrice("platinum", 10);
		assertEquals(2124,totalPrice,2);
		
	}
	
	

}
