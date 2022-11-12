package waa.lab5.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.lab5.restful.entity.dto.UserDto;
import waa.lab5.restful.service.JwtService;
import waa.lab5.restful.service.UserService;

@RestController
@RequestMapping("api/v1/authenticate")
public class JwtController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public String getToken(@RequestBody UserDto userDto){

        return jwtService.signIn(userDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void save(@RequestBody UserDto u){
        userService.save(u);
    }

}
