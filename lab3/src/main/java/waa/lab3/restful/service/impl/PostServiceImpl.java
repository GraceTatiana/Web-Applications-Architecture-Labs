package waa.lab3.restful.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab3.restful.entity.dto.PostDto;
import waa.lab3.restful.entity.dto.versioning.Comment;
import waa.lab3.restful.entity.dto.versioning.Post;
import waa.lab3.restful.repo.CommentRepo;
import waa.lab3.restful.repo.PostRepo;
import waa.lab3.restful.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private CommentRepo commentRepo;
    @Autowired
     private PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
         List<Post> posts = postRepo.findAll();
         return posts
                 .stream()
                 .map(post -> modelMapper.map(post,PostDto.class))
                 .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) {
        List<Post> posts = postRepo.findAll();
             return posts
                     .stream()
                     .map(p -> modelMapper.map(p, PostDto.class))
                     .filter(p -> p.getId() ==id)
                     .findFirst()
                     .orElse(null);
    }


    @Override
    public void save( PostDto p) {
        // before saving we have to change it into Post
       postRepo.save(modelMapper.map(p,Post.class));
//     postRepo.save(p);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);

    }

    @Override
    public void update(Long id, PostDto p) {
            PostDto post = findById(id);
            post.setAuthor(p.getAuthor());
            post.setContent(p.getContent());
            post.setId(p.getId());
            save(p);
    }

    @Override
    public List<PostDto> findAllEqualTo(String author) {
        return findAll()
                .stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public void addCommentToPost(Long id, Comment comment) {
         Post post =  postRepo.findById(id).get();
         List<Comment> comments =  post.getComments();
         comments.add(comment);
         postRepo.save(post);
    }

    @Override
    public List<Comment> getCommentsOfThisPost(Long id) {
        Post p = postRepo.findById(id).get();
        return p.getComments();
    }

    @Override
    public List<Post> findMatchingTitle(String title) {
        return postRepo.findPostByTitleLike(title);
    }


}
