package emt_labs2_196014.service;

import emt_labs2_196014.model.Author;
import emt_labs2_196014.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> create( Author a);

    void delete(Long authorId);

    Optional<Author> authorDtoToAuthor(AuthorDto author);

}
