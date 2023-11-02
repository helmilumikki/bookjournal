package hh.sof03.bookjournal.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genre_id;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    @JsonIgnoreProperties ("genre") 
    private List<Book> books;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public long getGenreid() {
        return genre_id;
    }

    public void setGenreid(long genreid) {
        this.genre_id = genreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    

}
