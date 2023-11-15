package hh.sof03.bookjournal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long review_id;

	private String postedDate;

	@NotEmpty(message = "You can't post an empty review")
	private String reviewText;

	@ManyToOne
	@JsonIgnoreProperties("reviews")
	@JoinColumn(name = "id")
	private Book book;

	public Review() {
	}

	public Review(String postedDate, String reviewText, Book book) {
		this.postedDate = postedDate;
		this.reviewText = reviewText;
		this.book = book;
	}

	public long getReview_id() {
		return review_id;
	}

	public void setReview_id(long review_id) {
		this.review_id = review_id;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
