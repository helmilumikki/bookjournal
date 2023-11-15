package hh.sof03.bookjournal.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByBook(Book book);

}
