package hh.sof03.bookjournal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long review_id;
    private String postedDate;
    private String startedReadingDate;
    private String finishedReadingDate;
    private String reviewText;
}
