package pl.csanecki.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.csanecki.restapi.model.Post;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPosts() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @GetMapping("/posts/{postId}")
    public Post getSinglePost(@PathVariable long postId) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
