package se331.project.rest.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Announcement;

public interface AnnouncementDao {
    Integer getAnnouncementSize();

    Page<Announcement> getAnnouncement(Integer pageSize, Integer page);

    Announcement getAnnouncementById(Long id);

    Announcement save(Announcement announcement);

    Page<Announcement> getAnnouncements(Long advisorId, Pageable page);

    Optional<Announcement> findById(Long id);
}
