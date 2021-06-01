package in.riyasahamed.model;

public class Movie {
	
	private String name;
	
	public String getName() {
		return name;
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

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	private String screen;
	
	private String status;

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Movie() {
		//Default Constructor
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + ", movieId=" + movieId + ", actor=" + actor + ", screen="
				+ screen + ", status=" + status + "]";
	}

}
