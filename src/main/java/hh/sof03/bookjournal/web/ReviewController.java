package hh.sof03.bookjournal.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookjournal.domain.BookRepository;
import hh.sof03.bookjournal.domain.Review;
import hh.sof03.bookjournal.domain.ReviewRepository;
import jakarta.validation.Valid;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/home")
    public String reviewList(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "home";
    }

    @GetMapping("/new-review")
    public String newReview(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("books", bookRepository.findAll());
        return "newreview";
    }

    @PostMapping("/savereview")
    public String saveReview(@Valid @ModelAttribute("review") Review review, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            reviewRepository.save(review);
        } else {
            model.addAttribute("books", bookRepository.findAll());
            return "newreview";
        }
        return "redirect:home";
    }

}
