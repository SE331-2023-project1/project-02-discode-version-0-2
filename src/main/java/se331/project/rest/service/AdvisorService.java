package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Announcement;

import java.util.List;

public interface AdvisorService {
    List<Advisor> getAllAdvisor();
    Page<Advisor> getAdvisor(Integer pageSize, Integer page);
    Advisor getAdvisorById (Long id);
    Page<Advisor> getAdvisors (String name, String surname, Pageable pageReq);
    Advisor save(Advisor advisor);

}