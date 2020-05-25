package pl.csanecki.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.csanecki.restapi.model.Post;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPosts() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
