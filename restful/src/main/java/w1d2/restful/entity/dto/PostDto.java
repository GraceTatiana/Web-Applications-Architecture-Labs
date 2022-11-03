package w1d2.restful.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
