package hh.sof03.bookjournal.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Title can't be empty")
    private String title;

    @NotEmpty(message = "ISBN can't be empty")
    private String isbn;

    private int releaseYear;

    @ManyToOne
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Review> reviews;

    public Book() {
    }

    public Book(String title, String isbn, int releaseYear, Genre genre, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
