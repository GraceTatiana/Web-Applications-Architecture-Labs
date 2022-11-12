package waa.lab6.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import waa.lab6.restful.entity.dto.versioning.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
    public List<User> userWithMoreThanOnePost();

    //7-	Make a query that will retrieve all the users that have more than (n) posts.
    @Query(value = "select u from User u where u.posts.size > :n")
    public List<User> usersHasMoreThanNPosts(int n);


    Optional<User> findByEmail(String email);
}
