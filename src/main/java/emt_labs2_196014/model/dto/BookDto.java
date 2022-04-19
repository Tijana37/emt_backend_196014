package emt_labs2_196014.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    String name;

    String category;

    Long author;

    Integer availableCopies;

}