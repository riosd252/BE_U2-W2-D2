package DavidRios.BE_U2W2D2.services;

import DavidRios.BE_U2W2D2.entities.BlogPost;
import DavidRios.BE_U2W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogPosts() {
        return this.blogPosts;
    }
    
    public BlogPost getPostById(long id) {
        BlogPost found = null;
        for (BlogPost post : this.blogPosts) {
            if (post.getId() == id) found = post;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public BlogPost savePost(BlogPost newPost) {
        Random rand = new Random();
        newPost.setId(rand.nextLong(1, 20000));
        this.blogPosts.add(newPost);
        return newPost;
    }

    public BlogPost updatePost (long id, BlogPost updatedPost) {
        BlogPost postToUpdate = getPostById(id);
        postToUpdate.setCategoria(updatedPost.getCategoria());
        postToUpdate.setContenuto(updatedPost.getContenuto());
        postToUpdate.setTitolo(updatedPost.getTitolo());
        postToUpdate.setCoverUrl(updatedPost.getCoverUrl());
        postToUpdate.setTempoDiLettura(updatedPost.getTempoDiLettura());

        return postToUpdate;
    }

    public void deletePost (long id) {
        this.blogPosts.removeIf(current -> current.getId() == id);
    }
}
