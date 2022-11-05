package waa.lab3.restful.service;

import waa.lab3.restful.entity.dto.CommentDto;
import waa.lab3.restful.entity.dto.PostDto;
import waa.lab3.restful.entity.dto.versioning.Comment;
import waa.lab3.restful.entity.dto.versioning.Post;

import java.util.List;


public interface PostService {

    public List<PostDto> findAll();
    public PostDto findById(Long id);

    public void save(PostDto p);

    public void delete(Long id);

    public void update(Long id, PostDto p);
    public List<PostDto> findAllEqualTo(String author);

    void addCommentToPost(Long id, Comment comment);

    List<CommentDto> getCommentsOfThisPost(Long id);

    List<Post> findMatchingTitle(String title);
}
