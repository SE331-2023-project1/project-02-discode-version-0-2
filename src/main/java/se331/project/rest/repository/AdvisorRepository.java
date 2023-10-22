package se331.project.rest.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Advisor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findAll();
    Page<Advisor> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase (String name, String surname, Pageable pageReq);
}
