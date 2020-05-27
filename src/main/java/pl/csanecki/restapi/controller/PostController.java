package pl.csanecki.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.csanecki.restapi.dto.PostDto;
import pl.csanecki.restapi.model.Post;
import pl.csanecki.restapi.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts() {
        return mapToPostDtos(postService.getPosts());
    }

    private List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(this::mapToPostDto)
                .collect(Collectors.toList());
    }

    private PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();
    }

    @GetMapping("/posts/{postId}")
    public Post getSinglePost(@PathVariable long postId) {
        return postService.getSinglePost(postId);
    }
}
