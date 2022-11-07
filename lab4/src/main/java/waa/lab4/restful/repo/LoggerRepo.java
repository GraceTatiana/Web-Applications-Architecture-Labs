package waa.lab4.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab4.restful.entity.dto.Logger;

@Repository
public interface LoggerRepo extends JpaRepository<Logger,Long> {
}
