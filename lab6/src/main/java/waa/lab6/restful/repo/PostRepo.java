package waa.lab6.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab6.restful.entity.dto.versioning.Post;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    //8-	Make a query that will find all the posts that match a given title.
    List<Post> findPostByTitleLike (String title);

}
