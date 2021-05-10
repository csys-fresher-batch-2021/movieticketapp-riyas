package in.riyasahamed.model;

public class Movie {
	
	public String name;
	
	public Integer tickets;
	
	public Float rating;
	
	public String actor;
		
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
