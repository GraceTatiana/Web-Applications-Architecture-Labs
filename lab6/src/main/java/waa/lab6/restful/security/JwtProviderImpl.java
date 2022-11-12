package waa.lab6.restful.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import waa.lab6.restful.entity.dto.versioning.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JwtProviderImpl implements JwtProvider {
    private final String secret = "SecretWord";

    @Override
    public String generateToken(UserPrincipal userPrincipal) {
        String authorities = userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        long jwtExpiryTime = 3000000000L;

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("Roles", authorities)
                .claim("UserId", userPrincipal.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiryTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest httpServletRequest) {
        Claims claims = extractClaims(httpServletRequest);

        if (Objects.isNull(claims)) {
            return null;
        }
        String userName = claims.getSubject();
        Long userId = claims.get("UserId", Long.class);
        List<Role> authorities = Arrays.stream(claims.get("Roles").toString().split(",")).map(role -> new Role(userId, role)).collect(Collectors.toList());

        if (Objects.isNull(userName)) {
            return null;
        }
        UserDetails userDetails = UserPrincipal.builder().email(userName).roles(authorities).id(userId).build();

        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities.stream().map(role -> {
            String formattedRole = role.getRole().startsWith("ROLE_") ? role.getRole() : "ROLE_" + role.getRole();
            return new SimpleGrantedAuthority(formattedRole);
        }).collect(Collectors.toList()));
    }

    private Claims extractClaims(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String jwtToken = null;
        if (StringUtils.hasLength(token) && token.startsWith("Bearer ")) {
            jwtToken = token.substring(7);
        }

        if (Objects.isNull(jwtToken)) {
            return null;
        }

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    @Override
    public boolean isTokenValid(HttpServletRequest httpServletRequest) {
        Claims claims = extractClaims(httpServletRequest);

        if (Objects.isNull(claims)) {
            return false;
        }

        return !claims.getExpiration().before(new Date());
    }
}
