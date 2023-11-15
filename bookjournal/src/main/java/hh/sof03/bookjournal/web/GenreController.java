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

import hh.sof03.bookjournal.domain.Genre;
import hh.sof03.bookjournal.domain.GenreRepository;
import jakarta.validation.Valid;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;

	@GetMapping("/genres")
	public String genrelist(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "genrelist";
	}

	@GetMapping("/addgenre")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}

	@PostMapping("/add/savegenre")
	public String saveNewGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			genreRepo.save(genre);
		} else {
			return "addgenre";
		}
		return "redirect:genres";
	}

	@GetMapping("/editgenre/{genre_id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editGenre(@PathVariable("genre_id") long genreId, Model model) {
		model.addAttribute("genre", genreRepo.findById(genreId));
		return "editgenre";
	}

	@PostMapping("/edit/savegenre")
	public String saveEditedGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			genreRepo.save(genre);
		} else {
			return "editgenre";
		}
		return "redirect:genres";
	}
}
