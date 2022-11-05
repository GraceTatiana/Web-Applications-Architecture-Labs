package waa.lab2.restful.service;

import waa.lab2.restful.entity.dto.PostDto;

import java.util.List;


public interface PostService {

    public List<PostDto> findAll();
    public PostDto findById(Long id);

    public void save(PostDto p);

    public void delete(Long id);

    public void update(Long id, PostDto p);
    public List<PostDto> findAllEqualTo(String author);
}
