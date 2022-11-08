package waa.lab2.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab2.restful.entity.dto.versioning.Post;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {


}
