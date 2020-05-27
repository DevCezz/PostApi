package pl.csanecki.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.csanecki.restapi.model.Post;
import pl.csanecki.restapi.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;

    private final PostRepository postRepository;

    public List<Post> getPosts(int page) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsWithComments(int page) {
        List<Post> posts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
        List<Long> postsIds = posts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        throw new IllegalArgumentException("Not implemented yet");
    }
}
