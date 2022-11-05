package waa.lab2.restful.entity.dto;

import lombok.Data;
import waa.lab2.restful.entity.dto.versioning.Post;

import java.util.List;

@Data
public class UserDto {
    long id;
    String name;
    List<Post> posts;
}
