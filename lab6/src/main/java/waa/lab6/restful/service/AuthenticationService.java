package waa.lab6.restful.service;

import waa.lab6.restful.entity.dto.TokenDto;
import waa.lab6.restful.entity.dto.UserDto;

public interface AuthenticationService {
    TokenDto signIn(UserDto userDto);
}
