package pl.csanecki.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.csanecki.restapi.model.Post;
import pl.csanecki.restapi.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
