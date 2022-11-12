package waa.lab6.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab6.restful.entity.dto.versioning.JwtRefreshToken;

@Repository
public interface RefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {
}
