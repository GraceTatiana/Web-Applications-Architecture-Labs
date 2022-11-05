package waa.lab3.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import waa.lab3.restful.entity.dto.PostDto;
import waa.lab3.restful.entity.dto.versioning.Comment;
import waa.lab3.restful.entity.dto.versioning.Post;
import waa.lab3.restful.entity.dto.versioning.PostV2;
import waa.lab3.restful.service.PostService;

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

    //  api/posts
    @PostMapping("/{id}/comment")
    public void addCommentToPost(@PathVariable("id") Long id, @RequestBody Comment comment){
        postService.addCommentToPost(id,comment);
    }

    @GetMapping("/{id}/comment")
    public List<Comment> getCommentsOfThisPost(@PathVariable("id") Long id){
        return postService.getCommentsOfThisPost(id);
    }

//    @GetMapping(value = "/post/header", headers = "P-API-VERSION=1")
//    public Post headerV1(){
//        return new Post(124L,"Food for thought","Read my book!!", "Anon");
//    }
//
//    @GetMapping(value = "/post/header", headers = "P-API-VERSION=2")
//    public PostV2 headerV2(){
//        return new PostV2(114L,"Food for thought2","Read my book, too!!", "Anon2");
//    }

    // localhost:8088/api/v1/posts/findMatchingTitle/title1
    @GetMapping("/findMatchingTitle/{title}")
    public List<Post> findMatchingTitle(@PathVariable("title") String title){
        return postService.findMatchingTitle(title);
    }
}
