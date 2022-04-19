package emt_labs2_196014.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import emt_labs2_196014.model.enums.Category;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String name;
    @Enumerated(value = EnumType.STRING)
    Category category;
    @OneToOne
    Author author;
    Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
