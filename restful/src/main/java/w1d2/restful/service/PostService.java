package w1d2.restful.service;

import w1d2.restful.entity.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> findAll();
    public PostDto findById(long id);

    public void save(PostDto p);

    public void delete(long id);

    public void update(long id, PostDto p);
    public List<PostDto> findAllEqualTo(String author);
}
