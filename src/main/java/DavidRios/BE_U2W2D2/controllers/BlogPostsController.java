package DavidRios.BE_U2W2D2.controllers;

import DavidRios.BE_U2W2D2.entities.BlogPost;
import DavidRios.BE_U2W2D2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return this.blogPostService.getBlogPosts();
    }

    @PostMapping
    public BlogPost saveBlogPost(@RequestBody BlogPost newPost) {
        return this.blogPostService.savePost(newPost);
    }

    @GetMapping("/{id}")
    public BlogPost getPostById(@PathVariable long id) {
       return this.blogPostService.getPostById(id);
    }

    @PutMapping("/{id}")
    public BlogPost getPostAndUpdate(@PathVariable long id, @RequestBody BlogPost updatedPost) {
      return this.blogPostService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        this.blogPostService.deletePost(id);
    }
}
