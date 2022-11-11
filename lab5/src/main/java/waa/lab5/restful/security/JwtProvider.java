package waa.lab5.restful.security;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {

    public String generateToken(UserPrinciple userPrinciple);
    public Authentication getAuthentication(HttpServletRequest httpServletRequest);
    public boolean isTokenValid(HttpServletRequest httpServletRequest);
}
