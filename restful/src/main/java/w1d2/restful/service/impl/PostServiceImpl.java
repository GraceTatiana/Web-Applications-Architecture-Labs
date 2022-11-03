package w1d2.restful.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import w1d2.restful.entity.dto.PostDto;
import w1d2.restful.entity.dto.versioning.Post;
import w1d2.restful.helper.ListMapper;
import w1d2.restful.repo.PostRepo;
import w1d2.restful.service.PostService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToPostDto
                .mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, PostDto p) {
        postRepo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findAllEqualTo(String author) {
        return (List<PostDto>) listMapperPostToPostDto.mapList(postRepo.findAllEqualTo(author), new PostDto());
    }
}
