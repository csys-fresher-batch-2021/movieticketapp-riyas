package in.riyasahamed.model;

public class Movie {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	private Integer tickets;
	
	public Integer getTickets() {
		return tickets;
	}
	
	private Float rating;
	
	public Float getRating() {
		return rating;
	}
		
	private String actor;
	
	public String getActor() {
		return actor;
	}
		
	public Movie(String name, String actor , Float rating) {
		
		this.name=name;
		this.actor=actor;
		this.rating=rating;
		//Assigning Default Values
		this.tickets=500;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", tickets=" + tickets + ", rating=" + rating + ", actor=" + actor + "]";
	}

}
