package w1d2.restful.repo.impl;

import org.springframework.stereotype.Repository;
import w1d2.restful.entity.dto.versioning.Post;
import w1d2.restful.repo.PostRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;

    private static int postId = 789;

    static{
         posts = new ArrayList<>();
         Post p1 = new Post(123, "My new Cat","She is really skinny and has three legs!", "CatWoman09");
         Post p2 = new Post(134, "We are going Hunting","My buddies and i are going to hunt some wild bears","Jack007");
         Post p3 = new Post(231, "My teacher", "My teacher loves to teach us Literature!!","StudentUni1");

            posts.add(p1);
            posts.add(p2);
            posts.add(p3);
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(long id) {
        var post = posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();

        posts.remove(post);
    }

    @Override
    public void update(long id, Post p) {
        Post postToUpdate = findById(id);
        postToUpdate.setContent(p.getContent());
        postToUpdate.setTitle(p.getTitle());
    }

    @Override
    public List<Post> findAllEqualTo(String author) {
        return posts.stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

}
