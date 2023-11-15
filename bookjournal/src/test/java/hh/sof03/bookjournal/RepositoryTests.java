package hh.sof03.bookjournal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookjournal.domain.Author;
import hh.sof03.bookjournal.domain.AuthorRepository;
import hh.sof03.bookjournal.domain.Book;
import hh.sof03.bookjournal.domain.BookRepository;
import hh.sof03.bookjournal.domain.Genre;
import hh.sof03.bookjournal.domain.GenreRepository;
import hh.sof03.bookjournal.domain.Review;
import hh.sof03.bookjournal.domain.ReviewRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoryTests {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	public void createNewReview() {
		Genre genre = new Genre("romance");
		genreRepository.save(genre);
		assertThat(genre.getGenre_id()).isNotNull();
		Author author = new Author("Jane Austen");
		authorRepository.save(author);
		assertThat(author.getAuthor_id()).isNotNull();
		Book book = new Book("Pride and Prejudice", "11203003", 1813, genre, author);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
		Review review = new Review("15.11.2023", "Great book", book);
		reviewRepository.save(review);
		assertThat(review.getReview_id()).isNotNull();
	}
}
