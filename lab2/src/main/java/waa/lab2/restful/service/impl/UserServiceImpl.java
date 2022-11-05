package waa.lab2.restful.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab2.restful.entity.dto.PostDto;
import waa.lab2.restful.entity.dto.UserDto;
import waa.lab2.restful.entity.dto.versioning.Post;
import waa.lab2.restful.entity.dto.versioning.User;
import waa.lab2.restful.repo.PostRepo;
import waa.lab2.restful.repo.UserRepo;
import waa.lab2.restful.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

//    @Override
//    public List<UserDto> findAll() {
//        List<User> user  = userRepo.userWithMoreThanOnePost();
//        return user.stream()
//                .map(p -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
//
//    }
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
//        List<User> users = userRepo.findAll();
//        return users
//                .stream()

//                .map(p -> modelMapper.map(p,UserDto.class))
//                .filter(p -> p.getId() ==id)
//                .map(p -> modelMapper.map(p.getPosts(), PostDto.class))
//                .collect(Collectors.toList());

        Optional<User> user = userRepo.findById(id);

        return user.get().getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());

 }

    @Override
    public void save(UserDto u) {

       userRepo.save(modelMapper.map(u,User.class));
    }

    @Override
    public Post createUserPost(Long id, PostDto p){
        User user = userRepo.findById(id).get();
       // p.setUser(user);
           user.getPosts().add(modelMapper.map(p, Post.class));
            postRepo.saveAll(user.getPosts());
            return modelMapper.map(p, Post.class);


       //return postRepo.save(modelMapper.map(p, Post.class));
    }


}
