package pl.csanecki.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.csanecki.restapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
