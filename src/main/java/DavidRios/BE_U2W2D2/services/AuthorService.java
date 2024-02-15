package DavidRios.BE_U2W2D2.services;

import DavidRios.BE_U2W2D2.entities.Author;
import DavidRios.BE_U2W2D2.exceptions.BadRequestException;
import DavidRios.BE_U2W2D2.exceptions.NotFoundException;
import DavidRios.BE_U2W2D2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Page<Author> getAuthors(int pageNumber, int size, String orderBy) {
        if (size > 20) size = 20;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return authorRepository.findAll(pageable);
    }
    
    public Author getAuthorById(long id) {
      return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author saveAuthor(Author newAuthor) {
        authorRepository.findByEmail(newAuthor.getEmail()).ifPresent(author -> { throw new BadRequestException("L'email " + author.getEmail() + " è già in uso!");
        });
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor (long id, Author updatedAuthor) {
        Author authorToUpdate = getAuthorById(id);
        authorToUpdate.setNome(updatedAuthor.getNome());
        authorToUpdate.setCognome(updatedAuthor.getCognome());
        authorToUpdate.setEmail(updatedAuthor.getEmail());
        authorToUpdate.setAvatar(updatedAuthor.getAvatar());
        authorToUpdate.setDataDiNascita(updatedAuthor.getDataDiNascita());

        return authorRepository.save(authorToUpdate);
    }

    public void deleteAuthor (long id) {
        this.authorRepository.delete(this.getAuthorById(id));
    }
}
