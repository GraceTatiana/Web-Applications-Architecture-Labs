package waa.lab2.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab2.restful.entity.dto.versioning.Post;
import waa.lab2.restful.entity.dto.versioning.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.posts.size = 1")
    public List<User> userWithMoreThanOnePost();
}
