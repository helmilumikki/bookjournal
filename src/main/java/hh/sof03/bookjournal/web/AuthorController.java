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

import hh.sof03.bookjournal.domain.Author;
import hh.sof03.bookjournal.domain.AuthorRepository;
import jakarta.validation.Valid;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@GetMapping("/authors")
	public String authorList(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authorlist";
	}

	@GetMapping("/addauthor")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "addauthor";
	}

	@PostMapping("/add/saveauthor")
	public String saveAddedGenre(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			authorRepo.save(author);
		} else {
			return "addauthor";
		}
		return "redirect:/authors";
	}

	@GetMapping("/editauthor/{author_id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editAuthor(@PathVariable("author_id") long authorId, Model model) {
		model.addAttribute("author", authorRepo.findById(authorId));
		return "editauthor";
	}

	@PostMapping("/edit/saveauthor")
	public String saveNewGenre(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			authorRepo.save(author);
		} else {
			return "editauthor";
		}
		return "redirect:/authors";
	}
}
