package waa.lab6.restful.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import waa.lab6.restful.entity.dto.PostDto;
import waa.lab6.restful.entity.dto.UserDto;
import waa.lab6.restful.entity.dto.versioning.Post;
import waa.lab6.restful.entity.dto.versioning.User;
import waa.lab6.restful.repo.PostRepo;
import waa.lab6.restful.repo.UserRepo;
import waa.lab6.restful.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> user  = userRepo.userWithMoreThanOnePost();
        return user.stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto findById(Long id) {
        List<User> users = userRepo.findAll();
        return users
                .stream()
                .map(p -> modelMapper.map(p,UserDto.class))
                .filter(p -> p.getId() ==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PostDto> getAllUserPosts(Long id) {
        Optional<User> user = userRepo.findById(id);

        return user.get().getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserDto> usersHasMoreThanNPosts(int n) {
         List<User> users = userRepo.usersHasMoreThanNPosts(n);
             return users
                     .stream()
                     .map(user -> modelMapper.map(user, UserDto.class))
                     .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> userWithMoreThanOnePost() {
        List <User> users= userRepo.userWithMoreThanOnePost();
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDto u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepo.save(modelMapper.map(u,User.class));
    }

    @Override
    public Post createUserPost(Long id, PostDto p){
        User user = userRepo.findById(id).get();

        user.getPosts().add(modelMapper.map(p, Post.class));

        postRepo.saveAll(user.getPosts());

        return modelMapper.map(p, Post.class);


    }


}
