package pl.csanecki.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.restapi.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdIn(List<Long> postsIds);
}
