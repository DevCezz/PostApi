package pl.csanecki.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.restapi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
