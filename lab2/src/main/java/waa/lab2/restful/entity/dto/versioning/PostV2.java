package waa.lab2.restful.entity.dto.versioning;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostV2 {
    Long id;
    String title;
    String content;
    String author;

}
