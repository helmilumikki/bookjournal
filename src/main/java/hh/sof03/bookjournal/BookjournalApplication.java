package hh.sof03.bookjournal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookjournal.domain.Author;
import hh.sof03.bookjournal.domain.AuthorRepository;
import hh.sof03.bookjournal.domain.Book;
import hh.sof03.bookjournal.domain.BookRepository;
import hh.sof03.bookjournal.domain.Genre;
import hh.sof03.bookjournal.domain.GenreRepository;
import hh.sof03.bookjournal.domain.Review;
import hh.sof03.bookjournal.domain.ReviewRepository;
import hh.sof03.bookjournal.domain.User;
import hh.sof03.bookjournal.domain.UserRepository;

@SpringBootApplication
public class BookjournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookjournalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepo, AuthorRepository authroRepo,
			GenreRepository genreRepo, ReviewRepository reviewRepo, UserRepository userRepo) {
		return (args) -> {

			Genre genre1 = new Genre("Fantasy");
			genreRepo.save(genre1);
			Genre genre2 = new Genre("Thriller");
			genreRepo.save(genre2);

			Author author1 = new Author("Shirley Jackson");
			authroRepo.save(author1);
			Author author2 = new Author("Tove Jansson");
			authroRepo.save(author2);

			Book book1 = new Book("We Have Always Lived in the Castle", "9780143039976", 1962, genre2, author1);
			bookRepo.save(book1);
			Book book2 = new Book("Moominland Midwinter", "9780713639803", 1957, genre1, author2);
			bookRepo.save(book2);

			Review review1 = new Review("6.11.2023",
					"Bizarre, strange, haunting, sinister, disturbing, twisted, foreboding, suffocatingly claustrophobic, leaving you with the ever-growing sense of unease. What else can I say about this book to give it justice?",
					book1);
			reviewRepo.save(review1);
			Review review2 = new Review("6.11.2023",
					"When Moomintroll awakes from hibernation early he discovers a sunless, snow-covered world he had never even dreamed existed and I get what is definitely my favourite Moomins book so far. Simply magical.",
					book2);
			reviewRepo.save(review2);

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
		};
	}
}
