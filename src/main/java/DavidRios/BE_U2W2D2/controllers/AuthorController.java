package DavidRios.BE_U2W2D2.controllers;

import DavidRios.BE_U2W2D2.entities.Author;
import DavidRios.BE_U2W2D2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return this.authorService.getAuthors(page, size, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return this.authorService.saveAuthor(newAuthor);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return this.authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author getAuthorAndUpdate(@PathVariable long id, @RequestBody Author updatedAuthor) {
        return this.authorService.updateAuthor(id, updatedAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable long id) {
        this.authorService.deleteAuthor(id);
    }

}
