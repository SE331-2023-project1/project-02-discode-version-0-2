package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Advisor;

import java.util.List;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findAll();
}
