package hh.sof03.bookjournal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookjournal.domain.AuthorRepository;
import hh.sof03.bookjournal.domain.Book;
import hh.sof03.bookjournal.domain.BookRepository;
import hh.sof03.bookjournal.domain.GenreRepository;
import hh.sof03.bookjournal.domain.ReviewRepository;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private ReviewRepository reviewRepo;

	@GetMapping("/books")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}

	@GetMapping("/books/{id}")
	public String book(@PathVariable("id") Long bookId, Model model) {
		Book book = bookRepo.findById(bookId).get();
		model.addAttribute("book", book);
		model.addAttribute("reviews", reviewRepo.findByBook(book));
		return "book";
	}

	@GetMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepo.findById(bookId));
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		return "editbook";
	}

	@PostMapping("/edit/savebook")
	public String saveEditedBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			bookRepo.save(book);
		} else {
			model.addAttribute("authors", authorRepo.findAll());
			model.addAttribute("genres", genreRepo.findAll());
			return "editbook";
		}
		return "redirect:/books";
	}

	@GetMapping("/deletebook/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepo.deleteById(bookId);
		return "redirect:/books";
	}

	@GetMapping("/addbook")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		return "addbook";
	}

	@PostMapping("/add/savebook")
	public String saveNewBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			bookRepo.save(book);
		} else {
			model.addAttribute("authors", authorRepo.findAll());
			model.addAttribute("genres", genreRepo.findAll());
			return "addbook";
		}
		return "redirect:/books";
	}

}
