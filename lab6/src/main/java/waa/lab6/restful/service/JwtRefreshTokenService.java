package waa.lab6.restful.service;

import waa.lab6.restful.entity.dto.TokenDto;
import waa.lab6.restful.entity.dto.versioning.JwtRefreshToken;

public interface JwtRefreshTokenService {
    JwtRefreshToken createRefreshToken(Long userId);

    TokenDto generateAccessTokenFromRefreshToken(String refreshToken);
}
