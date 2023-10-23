package se331.project.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.project.rest.entity.Announcement;
import se331.project.rest.repository.AnnouncementRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;

    @Override
    public Integer getAnnouncementSize() {
        return Math.toIntExact(announcementRepository.count());
    }

    @Override
    public Page<Announcement> getAnnouncement(Integer pageSize, Integer page) {
        return announcementRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Announcement getAnnouncementById(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

    @Override
    public Announcement save(Announcement student) {
        return announcementRepository.save(student);
    }

    @Override
    public Page<Announcement> getAnnouncements(Long advisorId, Pageable page) {
        return announcementRepository.findByAdvisorId(advisorId, page);
    }

    @Override
    public Optional<Announcement> findById(Long id) {
        return announcementRepository.findById(id);
    }
}
