package DavidRios.BE_U2W2D2.controllers;

import DavidRios.BE_U2W2D2.entities.Author;
import DavidRios.BE_U2W2D2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return this.authorService.getAuthors();
    }

    @PostMapping
    public Author saveAuthors(@RequestBody Author newAuthor) {
        return this.authorService.saveAuthor(newAuthor);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return this.authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author getAuthorAndUpdate(@PathVariable long id, @RequestBody Author updatedAuthor) {
        return this.getAuthorAndUpdate(id, updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        this.authorService.deleteAuthor(id);
    }

}
