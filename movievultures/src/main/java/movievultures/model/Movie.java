package movievultures.model;

import java.util.Date;
import java.util.List;

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
	private int id;
	private String title;
	@OneToMany(mappedBy="movie")
	private List<Review> reviews;
	private String description;
	private Date date;
	private int eloRating;
	@ManyToMany
	@JoinTable(name="favorites",
	joinColumns={@JoinColumn(name="id")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>favoredBy;
	@ManyToMany
	@JoinTable(name="watchLater",
	joinColumns={@JoinColumn(name="id")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>watchQueue;
	@ManyToMany
	@JoinTable(name="recommendations",
	joinColumns={@JoinColumn(name="id")},
	inverseJoinColumns={@JoinColumn(name="username")})
	private List<User>recommendedTo;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getEloRating() {
		return eloRating;
	}
	public void setEloRating(int eloRating) {
		this.eloRating = eloRating;
	}

}