package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se331.project.rest.entity.Announcement;

import java.util.List;

@Service
public interface AnnouncementService {
    Integer getAnnouncementSize();
    Page<Announcement> getAnnouncement(Integer pageSize, Integer page);
    Announcement getAnnouncementById(Long id);
    Announcement save(Announcement announcement);
    Page<Announcement> getAnnouncements(Long advisorId, Pageable pageable);
}