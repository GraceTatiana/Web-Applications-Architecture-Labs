package waa.lab6.restful.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import waa.lab6.restful.entity.dto.TokenDto;
import waa.lab6.restful.entity.dto.UserDto;
import waa.lab6.restful.security.JwtProvider;
import waa.lab6.restful.security.UserPrincipal;
import waa.lab6.restful.service.AuthenticationService;
import waa.lab6.restful.service.JwtRefreshTokenService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final JwtRefreshTokenService jwtRefreshTokenService;

    @Override
    public TokenDto signIn(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        String token = jwtProvider.generateToken(userPrincipal);
        String refreshToken = jwtRefreshTokenService.createRefreshToken(userPrincipal.getId()).getTokenId();

        return TokenDto.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();
    }
}
