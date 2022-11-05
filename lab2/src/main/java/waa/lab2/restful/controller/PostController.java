package waa.lab2.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import waa.lab2.restful.entity.dto.PostDto;
import waa.lab2.restful.entity.dto.versioning.Post;
import waa.lab2.restful.entity.dto.versioning.PostV2;
import waa.lab2.restful.service.PostService;

import java.util.List;

@RestController
@RequestMapping("api/posts/")
public class PostController {

    private final PostService postService;

    @Autowired
    // constructor injection
    public PostController (PostService postService){
        this.postService = postService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable Long id){
        var post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p){
        postService.save(p);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody PostDto p){
        postService.update(id, p);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "filter", required = false) String author){
        if (author.equals(null)) return postService.findAll();
        return postService.findAllEqualTo(author);
    }

    @GetMapping(value = {
            "/handlingEndpoints",
            "/handlingEndpoints/{author}"
    })
    public String multipleEndpoints(@PathVariable(required = false) String author){
        if(author != null){
            return "author:" + author;
        }else{
            return "author not found";
        }
    }

    @GetMapping(value = "/post/header", headers = "P-API-VERSION=1")
    public Post headerV1(){
        return new Post(124L,"Food for thought","Read my book!!", "Anon");
    }

    @GetMapping(value = "/post/header", headers = "P-API-VERSION=2")
    public PostV2 headerV2(){
        return new PostV2(114L,"Food for thought2","Read my book, too!!", "Anon2");
    }
}
