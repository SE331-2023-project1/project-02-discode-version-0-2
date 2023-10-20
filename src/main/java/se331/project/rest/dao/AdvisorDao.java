package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;

import java.util.Optional;

public interface AdvisorDao {
    Page<Advisor> getAdvisor(Pageable pageRequest);
    Optional<Advisor> findById(Long id);
    Advisor save(Advisor Advisor);
}
