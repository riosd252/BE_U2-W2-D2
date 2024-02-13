package DavidRios.BE_U2W2D2.services;

import DavidRios.BE_U2W2D2.entities.Author;
import DavidRios.BE_U2W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;
    }
    
    public Author getAuthorById(long id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) found = author;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public Author saveAuthor(Author newAuthor) {
        Random rand = new Random();
        newAuthor.setId(rand.nextLong(1, 20000));
        this.authors.add(newAuthor);
        return newAuthor;
    }

    public Author updateAuthor (long id, Author updatedAuthor) {
        Author authorToUpdate = getAuthorById(id);
        authorToUpdate.setNome(updatedAuthor.getNome());
        authorToUpdate.setCognome(updatedAuthor.getCognome());
        authorToUpdate.setEmail(updatedAuthor.getEmail());
        authorToUpdate.setAvatar(updatedAuthor.getAvatar());
        authorToUpdate.setDataDiNascita(updatedAuthor.getDataDiNascita());

        return authorToUpdate;
    }

    public void deleteAuthor (long id) {
        this.authors.removeIf(current -> current.getId() == id);
    }
}
