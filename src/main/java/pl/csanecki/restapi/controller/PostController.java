package pl.csanecki.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<PostDto> getPosts() {
        return PostDtoMapper.mapToPostDtos(postService.getPosts());
    }

    @GetMapping("/posts/{postId}")
    public Post getSinglePost(@PathVariable long postId) {
        return postService.getSinglePost(postId);
    }
}
