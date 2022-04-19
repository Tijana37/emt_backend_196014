package emt_labs2_196014.service.impl;

import emt_labs2_196014.model.Author;
import emt_labs2_196014.model.Book;
import emt_labs2_196014.model.dto.BookDto;
import emt_labs2_196014.model.enums.Category;
import emt_labs2_196014.model.exceptions.AuthorNotFound;
import emt_labs2_196014.model.exceptions.BookNotFound;
import emt_labs2_196014.repository.AuthorRepository;
import emt_labs2_196014.repository.BookRepository;
import emt_labs2_196014.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(Book b) {
        return Optional.of(bookRepository.save(b));
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> edit(Long bookId, BookDto bookDto) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFound(bookId));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        System.out.println(bookDto.getCategory());
        System.out.println(Category.valueOf(bookDto.getCategory()));
        Category c = Category.valueOf(bookDto.getCategory());
        book.setCategory(c);

        Author a = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        book.setAuthor(a);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFound(bookId));
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> bookDtoToBook(BookDto bookDto) {
        Author a = authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        Category c = Category.valueOf(bookDto.getCategory());
        Book b = null;
        if(bookDto.getName()!=null && bookDto.getAvailableCopies()!=null )
            b = new Book(bookDto.getName(), c, a, bookDto.getAvailableCopies());
        return Optional.of(b);
    }
}
