package se331.project.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AdvisorDao;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Announcement;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    final AdvisorDao advisorDao;

    @Override
    public List<Advisor> getAllAdvisor() {
        return advisorDao.getAdvisor(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Advisor> getAdvisor(Integer pageSize, Integer page) {
        return advisorDao.getAdvisor(PageRequest.of(pageSize, page));
    }

    @Override
    public Advisor getAdvisorById(Long id) {
        return advisorDao.findById(id).orElse(null);
    }

    @Override
    public Page<Advisor> getAdvisors(String name, String surname, Pageable pageReq) {
        return advisorDao.getAdvisors(name, surname, pageReq);
    }

    @Override
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }




}
