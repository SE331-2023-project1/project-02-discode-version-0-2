package se331.project.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AnnouncementDao;
import se331.project.rest.entity.Announcement;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    final AnnouncementDao announcementDao;

    @Override
    public Integer getAnnouncementSize() {
        return announcementDao.getAnnouncementSize();
    }

    @Override
    public Page<Announcement> getAnnouncement(Integer pageSize, Integer page) {
        return announcementDao.getAnnouncement(pageSize, page);
    }

    @Override
    public Announcement getAnnouncementById(Long id) {
        return announcementDao.getAnnouncementById(id);
    }

    @Override
    @Transactional
    public Announcement save(Announcement announcement) {
        return announcementDao.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncements(Long advisorId, Pageable pageable) {
        return announcementDao.getAnnouncements(advisorId, pageable);
    }
}

