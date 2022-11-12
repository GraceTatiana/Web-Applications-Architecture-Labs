package waa.lab6.restful.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {

    public String generateToken(UserPrincipal userPrincipal);
    public Authentication getAuthentication(HttpServletRequest httpServletRequest);
    public boolean isTokenValid(HttpServletRequest httpServletRequest);
}
