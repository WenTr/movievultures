package movievultures.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="movies")
public class Movie {
	@Id
	@GeneratedValue
	private int movieId;
	private String title;
	
	@OneToMany(mappedBy="movie",
			cascade=CascadeType.ALL)
	private List<Review> reviews;
	private String description;
	private Date date;
	private double eloRating;
	private int eloTimesRated;
	@ManyToMany
	@JoinTable(name="favorites",
	joinColumns={@JoinColumn(name="movieId")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>favoredBy;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="watchLater",
	joinColumns={@JoinColumn(name="movieId")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>watchQueue;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="recommendations",
	joinColumns={@JoinColumn(name="movieId")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>recommendedTo;
	
	@ElementCollection
	@CollectionTable(
			name="movie_genres",
			joinColumns=@JoinColumn(name = "movieId")
			)
	@Column(name="genre")
	List<String> genres;
	
	public List<User> getFavoredBy() {
		return favoredBy;
	}
	public void setFavoredBy(List<User> favoredBy) {
		this.favoredBy = favoredBy;
	}
	public List<User> getWatchQueue() {
		return watchQueue;
	}
	public void setWatchQueue(List<User> watchQueue) {
		this.watchQueue = watchQueue;
	}
	public int getmovieId() {
		return movieId;
	}
	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getEloRating() {
		return eloRating;
	}
	public void setEloRating(double eloRating) {
		this.eloRating = eloRating;
	}
	public int getEloTimesRated() {
		return eloTimesRated;
	}
	public void setEloTimesRated(int eloTimesRated) {
		this.eloTimesRated = eloTimesRated;
	}

}
