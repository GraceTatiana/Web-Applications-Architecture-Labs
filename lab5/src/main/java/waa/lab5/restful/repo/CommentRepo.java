package waa.lab5.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.restful.entity.dto.versioning.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
