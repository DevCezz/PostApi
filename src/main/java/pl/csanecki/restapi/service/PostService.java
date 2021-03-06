package pl.csanecki.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.csanecki.restapi.model.Comment;
import pl.csanecki.restapi.model.Post;
import pl.csanecki.restapi.repository.CommentRepository;
import pl.csanecki.restapi.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final String POST_ID = "id";
    private static final int PAGE_SIZE = 20;

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, POST_ID)));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> posts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, POST_ID)));
        List<Long> postsIds = posts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(postsIds);
        posts.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return posts;
    }

    private List<Comment> extractComments(List<Comment> comments, long postId) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == postId)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post editingPost) {
        Optional<Post> foundPost = postRepository.findById(editingPost.getId());
        return foundPost.map(post -> {
            post.setTitle(editingPost.getTitle());
            post.setContent(editingPost.getContent());
            return post;
        }).orElseThrow();
    }

    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }
}
