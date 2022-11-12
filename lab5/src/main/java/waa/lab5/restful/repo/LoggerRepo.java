package waa.lab5.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab5.restful.entity.dto.versioning.Logger;

@Repository
public interface LoggerRepo extends JpaRepository<Logger,Long> {
}
