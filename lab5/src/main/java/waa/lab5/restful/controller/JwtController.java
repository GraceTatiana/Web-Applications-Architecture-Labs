package waa.lab5.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import waa.lab5.restful.entity.dto.UserDto;
import waa.lab5.restful.service.JwtService;

@RequestMapping("/authenticate ")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public String getToken(@RequestBody UserDto userDto){
       return jwtService.signIn(userDto);
    }
}
