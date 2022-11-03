package w1d2.restful.repo;

import w1d2.restful.entity.dto.versioning.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();
    public Post findById(long id);

    public void save(Post p);

    public void delete(long id);

    public void update(long id, Post p);

    public List<Post> findAllEqualTo(String author);

}
