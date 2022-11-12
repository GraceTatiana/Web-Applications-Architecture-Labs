package waa.lab6.restful.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab6.restful.entity.dto.TokenDto;
import waa.lab6.restful.entity.dto.versioning.JwtRefreshToken;
import waa.lab6.restful.entity.dto.versioning.User;
import waa.lab6.restful.repo.RefreshTokenRepository;
import waa.lab6.restful.repo.UserRepo;
import waa.lab6.restful.security.JwtProvider;
import waa.lab6.restful.security.UserPrincipal;
import waa.lab6.restful.service.JwtRefreshTokenService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@Transactional
@RequiredArgsConstructor
@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepo userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public JwtRefreshToken createRefreshToken(Long userId) {
        JwtRefreshToken jwtRefreshToken = new JwtRefreshToken();

        jwtRefreshToken.setTokenId(UUID.randomUUID().toString());
        jwtRefreshToken.setUserId(userId);
        jwtRefreshToken.setCreatedAt(LocalDateTime.now());
        long TOKEN_EXP_TIME = 6000000000L;
        jwtRefreshToken.setExpiresAt(LocalDateTime.now().plus(TOKEN_EXP_TIME, ChronoUnit.MILLIS));

        return refreshTokenRepository.save(jwtRefreshToken);

    }

    @Override
    public TokenDto generateAccessTokenFromRefreshToken(String refreshToken) {
        JwtRefreshToken jwtRefreshToken = refreshTokenRepository.findById(refreshToken).orElseThrow();

        if (jwtRefreshToken.getExpiresAt().isBefore(LocalDateTime.now()))
            throw new RuntimeException("Jwt Refresh token is not valid");

        User user = userRepository.findById(jwtRefreshToken.getUserId()).orElseThrow();

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();

        String accessToken = jwtProvider.generateToken(userPrincipal);

        return TokenDto.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
