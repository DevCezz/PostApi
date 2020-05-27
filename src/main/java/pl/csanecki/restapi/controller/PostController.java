package pl.csanecki.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.csanecki.restapi.dto.PostDto;
import pl.csanecki.restapi.model.Post;
import pl.csanecki.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(defaultValue = "ASC") Sort.Direction sort) {
        int requestedPage = page > 0 ? page : 0;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(requestedPage, sort));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(defaultValue = "ASC") Sort.Direction sort) {
        int requestedPage = page > 0 ? page : 0;
        return postService.getPostsWithComments(requestedPage, sort);
    }

    @GetMapping("/posts/{postId}")
    public Post getSinglePost(@PathVariable long postId) {
        return postService.getSinglePost(postId);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
