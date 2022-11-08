package waa.lab2.restful;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import waa.lab2.restful.entity.dto.versioning.Post;
import waa.lab2.restful.entity.dto.versioning.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
