package waa.lab5.restful.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import waa.lab5.restful.entity.dto.UserDto;
import waa.lab5.restful.entity.dto.versioning.User;
import waa.lab5.restful.security.CustomUserDetailsService;
import waa.lab5.restful.security.JwtProvider;
import waa.lab5.restful.security.UserPrinciple;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final CustomUserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private final JwtProvider jwtProvider;

    private final AuthenticationManager authenticationManager;

    public String signIn(UserDto userDto){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(),userDto.getPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return jwtProvider.generateToken(userPrinciple);
    }
}
