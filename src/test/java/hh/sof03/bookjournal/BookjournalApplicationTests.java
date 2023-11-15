package hh.sof03.bookjournal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.bookjournal.web.AuthorController;
import hh.sof03.bookjournal.web.BookController;
import hh.sof03.bookjournal.web.GenreController;
import hh.sof03.bookjournal.web.ReviewController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookjournalApplicationTests {

	@Autowired
	private AuthorController authorController;
	@Autowired
	private BookController bookController;
	@Autowired
	private GenreController genreController;
	@Autowired
	private ReviewController reviewController;

	@Test
	void contextLoads() throws Exception {
		assertThat(authorController).isNotNull();
		assertThat(bookController).isNotNull();
		assertThat(genreController).isNotNull();
		assertThat(reviewController).isNotNull();
	}

}
