package waa.lab2.restful.service;

import waa.lab2.restful.entity.dto.PostDto;
import waa.lab2.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    public UserDto findById(Long id);

    public List<PostDto> findAllEqualTo(Long id);

    public void save(UserDto u);

}
