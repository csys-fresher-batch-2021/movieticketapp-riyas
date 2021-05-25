package in.riyasahamed.dto;

public class MovieDTO {

	private String name;

	public String getName() {
		return name;
	}

	private Integer tickets;

	public Integer getTickets() {
		return tickets;
	}
	
	private Integer movieId;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	private Float rating;

	public Float getRating() {
		return rating;
	}

	private String actor;

	public String getActor() {
		return actor;
	}

	public MovieDTO(String name, String actor, Float rating) {

		this.name = name;
		this.actor = actor;
		this.rating = rating;
		// Assigning Default Values
		this.tickets = 500;
	}

	public MovieDTO() {
		// Default Constructor
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

	@Override
	public String toString() {
		return "MovieDTO [name=" + name + ", tickets=" + tickets + ", movieId=" + movieId + ", rating=" + rating
				+ ", actor=" + actor + "]";
	}

}
