package emt_labs2_196014.service;

import emt_labs2_196014.model.Book;
import emt_labs2_196014.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> create( Book b);

    void delete(Long bookId);

    Optional<Book> edit(Long bookId,BookDto bookDto);

    Optional<Book> markAsTaken(Long bookId);

    Optional<Book> bookDtoToBook(BookDto book);

}
