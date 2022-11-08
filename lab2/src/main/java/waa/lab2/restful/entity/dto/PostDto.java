package waa.lab2.restful.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import waa.lab2.restful.entity.dto.versioning.User;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private User user;
}
