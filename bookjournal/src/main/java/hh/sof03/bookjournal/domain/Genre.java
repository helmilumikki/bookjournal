package hh.sof03.bookjournal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genre_id;
    private String name;
    
}
