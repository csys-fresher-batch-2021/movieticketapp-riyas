package in.riyasahamed.dto;

public class MovieDTO {
	
	public MovieDTO() {
		// Default Constructor
	}


	private String name;

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "MovieDTO [name=" + name + ", movieId=" + movieId + ", rating=" + rating + ", actor=" + actor
				+ ", screen=" + screen + ", status=" + status + "]";
	}

}
