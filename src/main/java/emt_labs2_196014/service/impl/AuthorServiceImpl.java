package emt_labs2_196014.service.impl;

import emt_labs2_196014.model.Author;
import emt_labs2_196014.model.Country;
import emt_labs2_196014.model.dto.AuthorDto;
import emt_labs2_196014.model.exceptions.AuthorNotFound;
import emt_labs2_196014.repository.AuthorRepository;
import emt_labs2_196014.repository.countryRepository;
import emt_labs2_196014.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final countryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, countryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> create(Author a) {
        return Optional.of(authorRepository.save(a));
    }

    @Override
    public void delete(Long authorId) {
        Optional<Author> a = authorRepository.findById(authorId);
        if(a.isPresent())
            authorRepository.delete(a.get());
        else throw new AuthorNotFound(authorId);
    }

    @Override
    public Optional<Author> authorDtoToAuthor(AuthorDto author) {
        Country c = countryRepository.findById(author.getCountryId()).orElseThrow(()->new EmptyStackException());
        Author b = null;
        if (author.getName() != null && author.getSurname()!= null)
            b = new Author(author.getName(),author.getSurname(),c);
        return Optional.of(b);

    }
}
