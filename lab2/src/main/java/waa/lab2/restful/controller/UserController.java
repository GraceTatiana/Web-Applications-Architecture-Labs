package waa.lab2.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waa.lab2.restful.entity.dto.PostDto;
import waa.lab2.restful.entity.dto.UserDto;
import waa.lab2.restful.entity.dto.versioning.Post;
import waa.lab2.restful.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto u){
        userService.save(u);
    }

    @GetMapping
    public List<UserDto> findAll(){
       return userService.findAll();
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getAllUserPosts(@PathVariable Long id){
        return userService.getAllUserPosts(id);

    }

    @PostMapping("/{id}/posts")
    public Post createUserPost(@PathVariable Long id,@RequestBody PostDto p){
        return userService.createUserPost(id, p);

    }
}
