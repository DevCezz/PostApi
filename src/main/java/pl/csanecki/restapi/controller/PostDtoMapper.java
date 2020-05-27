package pl.csanecki.restapi.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.csanecki.restapi.dto.PostDto;
import pl.csanecki.restapi.model.Post;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostDtoMapper {

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(PostDtoMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    private static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();
    }
}
