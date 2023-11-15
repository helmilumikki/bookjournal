package hh.sof03.bookjournal.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.bookjournal.domain.Book;
import hh.sof03.bookjournal.domain.BookRepository;

@RestController
@RequestMapping("/rest")
public class BookRestController {

	@Autowired
	private BookRepository bookRepo;

	@GetMapping("/books")
	List<Book> listAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	@GetMapping("/books/{id}")
	Optional<Book> getBookById(@PathVariable("id") long bookId) {
		return bookRepo.findById(bookId);
	}

}
