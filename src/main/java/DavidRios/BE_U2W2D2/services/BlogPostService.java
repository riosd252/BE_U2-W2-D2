package DavidRios.BE_U2W2D2.services;

import DavidRios.BE_U2W2D2.entities.BlogPost;
import DavidRios.BE_U2W2D2.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    @Autowired
    BlogPostService blogPostService;

    public List<BlogPost> getBlogPosts() {
        return this.blogPostService.getBlogPosts();
    }
    
    public BlogPost getPostById(long id) {
        BlogPost found = null;
        for (BlogPost post : getBlogPosts()) {
            if (post.getId() == id) found = post;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public BlogPost savePost(BlogPost newPost) {
        this.blogPostService.savePost(newPost);
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
        this.blogPostService.deletePost(id);
    }
}
