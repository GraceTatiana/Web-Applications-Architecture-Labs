package waa.lab5.restful.service;

import waa.lab5.restful.entity.dto.PostDto;
import waa.lab5.restful.entity.dto.UserDto;
import waa.lab5.restful.entity.dto.versioning.Post;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    public UserDto findById(Long id);

    public void save(UserDto u);

    public Post createUserPost(Long id, PostDto p);

    public List<PostDto> getAllUserPosts(Long id);

    public List<UserDto> usersHasMoreThanNPosts(int n);

    public List<UserDto> userWithMoreThanOnePost();
}
