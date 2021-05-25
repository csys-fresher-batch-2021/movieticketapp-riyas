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
	
	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	private Integer movieId;
		
	private String actor;
	
	public String getActor() {
		return actor;
	}
		
	public void setName(String name) {
		this.name = name;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Movie(String name, String actor , Float rating) {
		
		this.name=name;
		this.actor=actor;
		this.rating=rating;
		//Assigning Default Values
		this.tickets=500;
	}

	public Movie() {
		//Default Constructor
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", tickets=" + tickets + ", rating=" + rating + ", movieId=" + movieId
				+ ", actor=" + actor + "]";
	}

}
