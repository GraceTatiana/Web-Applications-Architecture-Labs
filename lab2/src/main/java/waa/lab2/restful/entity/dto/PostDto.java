package waa.lab2.restful.entity.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class PostDto {
    Long id;
    String title;
    String content;
    String author;
}
