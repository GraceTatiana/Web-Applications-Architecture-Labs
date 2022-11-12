package waa.lab6.restful.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import waa.lab6.restful.entity.dto.versioning.Post;
import waa.lab6.restful.entity.dto.versioning.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private List<Post> posts;
    private List<Role> roles;
}
