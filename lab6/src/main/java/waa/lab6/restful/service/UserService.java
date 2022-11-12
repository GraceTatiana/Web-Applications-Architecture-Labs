package waa.lab6.restful.service;

import waa.lab6.restful.entity.dto.PostDto;
import waa.lab6.restful.entity.dto.UserDto;
import waa.lab6.restful.entity.dto.versioning.Post;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    void save(UserDto u);

    Post createUserPost(Long id, PostDto p);

    List<PostDto> getAllUserPosts(Long id);

    List<UserDto> usersHasMoreThanNPosts(int n);

    List<UserDto> userWithMoreThanOnePost();
}
