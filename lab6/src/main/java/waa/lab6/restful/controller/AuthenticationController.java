package waa.lab6.restful.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.lab6.restful.entity.dto.TokenDto;
import waa.lab6.restful.entity.dto.UserDto;
import waa.lab6.restful.service.AuthenticationService;
import waa.lab6.restful.service.JwtRefreshTokenService;
import waa.lab6.restful.service.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/authenticate")
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final JwtRefreshTokenService jwtRefreshTokenService;


    @PostMapping
    public TokenDto getToken(@RequestBody UserDto userDto){

        return authenticationService.signIn(userDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void save(@RequestBody UserDto u){
        userService.save(u);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/refreshToken/{token}")
    public TokenDto getRefreshToken(@PathVariable String token){
        return jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token);
    }

}
