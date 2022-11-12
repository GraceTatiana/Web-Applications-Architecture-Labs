package waa.lab6.restful.service;

import waa.lab6.restful.entity.dto.CommentDto;
import waa.lab6.restful.entity.dto.PostDto;
import waa.lab6.restful.entity.dto.versioning.Comment;
import waa.lab6.restful.entity.dto.versioning.Post;

import java.util.List;


public interface PostService {

    List<PostDto> findAll();

    PostDto findById(Long id);

    void save(PostDto p);

    void delete(Long id);

    void update(Long id, PostDto p);

    List<PostDto> findAllEqualTo(String author);

    void addCommentToPost(Long id, Comment comment);

    List<CommentDto> getCommentsOfThisPost(Long id);

    List<Post> findMatchingTitle(String title);
}
